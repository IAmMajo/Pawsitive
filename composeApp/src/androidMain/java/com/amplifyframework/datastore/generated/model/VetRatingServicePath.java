package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the VetRatingService type in your schema. */
public final class VetRatingServicePath extends ModelPath<VetRatingService> {

  private VetRatingPath rating;
  private ServicePath service;

  VetRatingServicePath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, VetRatingService.class);
  }

  public synchronized VetRatingPath getRating() {
    if (rating == null) {
      rating = new VetRatingPath("rating", false, this);
    }
    return rating;
  }

  public synchronized ServicePath getService() {
    if (service == null) {
      service = new ServicePath("service", false, this);
    }
    return service;
  }
}
