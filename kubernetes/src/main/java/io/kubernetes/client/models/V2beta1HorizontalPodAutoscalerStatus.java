/*
 * Kubernetes
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1.10.4
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.kubernetes.client.models;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.kubernetes.client.models.V2beta1HorizontalPodAutoscalerCondition;
import io.kubernetes.client.models.V2beta1MetricStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.
 */
@ApiModel(description = "HorizontalPodAutoscalerStatus describes the current status of a horizontal pod autoscaler.")

public class V2beta1HorizontalPodAutoscalerStatus {
  @SerializedName("conditions")
  private List<V2beta1HorizontalPodAutoscalerCondition> conditions = new ArrayList<V2beta1HorizontalPodAutoscalerCondition>();

  @SerializedName("currentMetrics")
  private List<V2beta1MetricStatus> currentMetrics = new ArrayList<V2beta1MetricStatus>();

  @SerializedName("currentReplicas")
  private Integer currentReplicas = null;

  @SerializedName("desiredReplicas")
  private Integer desiredReplicas = null;

  @SerializedName("lastScaleTime")
  private DateTime lastScaleTime = null;

  @SerializedName("observedGeneration")
  private Long observedGeneration = null;

  public V2beta1HorizontalPodAutoscalerStatus conditions(List<V2beta1HorizontalPodAutoscalerCondition> conditions) {
    this.conditions = conditions;
    return this;
  }

  public V2beta1HorizontalPodAutoscalerStatus addConditionsItem(V2beta1HorizontalPodAutoscalerCondition conditionsItem) {
    this.conditions.add(conditionsItem);
    return this;
  }

   /**
   * conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.
   * @return conditions
  **/
  @ApiModelProperty(required = true, value = "conditions is the set of conditions required for this autoscaler to scale its target, and indicates whether or not those conditions are met.")
  public List<V2beta1HorizontalPodAutoscalerCondition> getConditions() {
    return conditions;
  }

  public void setConditions(List<V2beta1HorizontalPodAutoscalerCondition> conditions) {
    this.conditions = conditions;
  }

  public V2beta1HorizontalPodAutoscalerStatus currentMetrics(List<V2beta1MetricStatus> currentMetrics) {
    this.currentMetrics = currentMetrics;
    return this;
  }

  public V2beta1HorizontalPodAutoscalerStatus addCurrentMetricsItem(V2beta1MetricStatus currentMetricsItem) {
    this.currentMetrics.add(currentMetricsItem);
    return this;
  }

   /**
   * currentMetrics is the last read state of the metrics used by this autoscaler.
   * @return currentMetrics
  **/
  @ApiModelProperty(required = true, value = "currentMetrics is the last read state of the metrics used by this autoscaler.")
  public List<V2beta1MetricStatus> getCurrentMetrics() {
    return currentMetrics;
  }

  public void setCurrentMetrics(List<V2beta1MetricStatus> currentMetrics) {
    this.currentMetrics = currentMetrics;
  }

  public V2beta1HorizontalPodAutoscalerStatus currentReplicas(Integer currentReplicas) {
    this.currentReplicas = currentReplicas;
    return this;
  }

   /**
   * currentReplicas is current number of replicas of pods managed by this autoscaler, as last seen by the autoscaler.
   * @return currentReplicas
  **/
  @ApiModelProperty(required = true, value = "currentReplicas is current number of replicas of pods managed by this autoscaler, as last seen by the autoscaler.")
  public Integer getCurrentReplicas() {
    return currentReplicas;
  }

  public void setCurrentReplicas(Integer currentReplicas) {
    this.currentReplicas = currentReplicas;
  }

  public V2beta1HorizontalPodAutoscalerStatus desiredReplicas(Integer desiredReplicas) {
    this.desiredReplicas = desiredReplicas;
    return this;
  }

   /**
   * desiredReplicas is the desired number of replicas of pods managed by this autoscaler, as last calculated by the autoscaler.
   * @return desiredReplicas
  **/
  @ApiModelProperty(required = true, value = "desiredReplicas is the desired number of replicas of pods managed by this autoscaler, as last calculated by the autoscaler.")
  public Integer getDesiredReplicas() {
    return desiredReplicas;
  }

  public void setDesiredReplicas(Integer desiredReplicas) {
    this.desiredReplicas = desiredReplicas;
  }

  public V2beta1HorizontalPodAutoscalerStatus lastScaleTime(DateTime lastScaleTime) {
    this.lastScaleTime = lastScaleTime;
    return this;
  }

   /**
   * lastScaleTime is the last time the HorizontalPodAutoscaler scaled the number of pods, used by the autoscaler to control how often the number of pods is changed.
   * @return lastScaleTime
  **/
  @ApiModelProperty(value = "lastScaleTime is the last time the HorizontalPodAutoscaler scaled the number of pods, used by the autoscaler to control how often the number of pods is changed.")
  public DateTime getLastScaleTime() {
    return lastScaleTime;
  }

  public void setLastScaleTime(DateTime lastScaleTime) {
    this.lastScaleTime = lastScaleTime;
  }

  public V2beta1HorizontalPodAutoscalerStatus observedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
    return this;
  }

   /**
   * observedGeneration is the most recent generation observed by this autoscaler.
   * @return observedGeneration
  **/
  @ApiModelProperty(value = "observedGeneration is the most recent generation observed by this autoscaler.")
  public Long getObservedGeneration() {
    return observedGeneration;
  }

  public void setObservedGeneration(Long observedGeneration) {
    this.observedGeneration = observedGeneration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    V2beta1HorizontalPodAutoscalerStatus v2beta1HorizontalPodAutoscalerStatus = (V2beta1HorizontalPodAutoscalerStatus) o;
    return Objects.equals(this.conditions, v2beta1HorizontalPodAutoscalerStatus.conditions) &&
        Objects.equals(this.currentMetrics, v2beta1HorizontalPodAutoscalerStatus.currentMetrics) &&
        Objects.equals(this.currentReplicas, v2beta1HorizontalPodAutoscalerStatus.currentReplicas) &&
        Objects.equals(this.desiredReplicas, v2beta1HorizontalPodAutoscalerStatus.desiredReplicas) &&
        Objects.equals(this.lastScaleTime, v2beta1HorizontalPodAutoscalerStatus.lastScaleTime) &&
        Objects.equals(this.observedGeneration, v2beta1HorizontalPodAutoscalerStatus.observedGeneration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conditions, currentMetrics, currentReplicas, desiredReplicas, lastScaleTime, observedGeneration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V2beta1HorizontalPodAutoscalerStatus {\n");
    
    sb.append("    conditions: ").append(toIndentedString(conditions)).append("\n");
    sb.append("    currentMetrics: ").append(toIndentedString(currentMetrics)).append("\n");
    sb.append("    currentReplicas: ").append(toIndentedString(currentReplicas)).append("\n");
    sb.append("    desiredReplicas: ").append(toIndentedString(desiredReplicas)).append("\n");
    sb.append("    lastScaleTime: ").append(toIndentedString(lastScaleTime)).append("\n");
    sb.append("    observedGeneration: ").append(toIndentedString(observedGeneration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

