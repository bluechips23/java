package io.kubernetes.client.examples;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.google.gson.reflect.TypeToken;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Event;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.Watch;

public class ComboWatchExample {

    private static ApiClient createApiClientGenerator() throws IOException {
        ApiClient client = Config.defaultClient();
        client.getHttpClient().setReadTimeout(60, TimeUnit.SECONDS);
        Configuration.setDefaultApiClient(client);
        return client;
    }

    public static void main( String args[] )  {
        System.out.println("Initializing...");
        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleWithFixedDelay(getPodsTask, 15, 20, TimeUnit.SECONDS);
        scheduledExecutorService.scheduleWithFixedDelay(watchEventsTask, 15, 12, TimeUnit.SECONDS);
    }

    final static Runnable watchEventsTask = new Runnable() {
        public void run() {
            ApiClient client = null;
            try {
                client = createApiClientGenerator();
            } catch ( IOException ioe ) {
                ioe.printStackTrace();
            }
            CoreV1Api coreV1Api = new CoreV1Api(client);
            try {
                System.out.println("Getting watch events...");
                Watch<V1Event> watch = Watch.createWatch(
                        client,
                        coreV1Api.listEventForAllNamespacesCall(null, null, null, null,
                                null, null, null, null, true, null, null),
                        new TypeToken<Watch.Response<V1Event>>() {}.getType());

                watch.forEach( response  -> {
                    V1Event event = response.object;
                    String kind = event.getKind();
                    String message = event.getMessage();
                    String name = event.getMetadata().getName();
                    System.out.printf("Event Name: %s, Kind: %s, Message: %s%n", name, kind, message);
                });
                System.out.println("---------- Watch Task Complete ----------");
            } catch ( ApiException e) {
                String errorMessage = "Failed to handle watch task for all events";
                System.err.println(errorMessage);
                e.printStackTrace();
            }
        }
    };

    final static Runnable getPodsTask = new Runnable() {
        public void run() {
            ApiClient client = null;
            try {
                client = createApiClientGenerator();
            } catch ( IOException ioe ) {
                ioe.printStackTrace();
            }
            CoreV1Api coreV1Api = new CoreV1Api(client);
            final String _continue = null;
            final String fieldSelector = null;
            final Boolean includeUninitialized = null;
            final String labelSelector = null;
            final Integer limit = null;
            final String pretty = null;
            final String resourceVersion = null;
            final Integer timeoutSeconds = null;
            final Boolean watch = false;

            try {
                System.out.println("Getting pod lists...");
                V1PodList podList = coreV1Api.listPodForAllNamespaces(
                                                _continue,
                                                fieldSelector,
                                                includeUninitialized,
                                                labelSelector,
                                                limit,
                                                pretty,
                                                resourceVersion,
                                                timeoutSeconds,
                                                watch);
                System.out.println("Received pod lists of size: " + podList.getItems().size());
                for (V1Pod item : podList.getItems()) {
                    String name = item.getMetadata().getName();
                    if ( !name.isEmpty() ) {
                        System.out.println("Pod: " + name);
                    }
                }
                System.out.println("---------- Pod Task Complete ----------");
            } catch ( ApiException e ) {
                String errorMessage = "Failed to get pods for all namespaces";
                System.err.println(errorMessage);
                e.printStackTrace();
            }
        }
    };
}
