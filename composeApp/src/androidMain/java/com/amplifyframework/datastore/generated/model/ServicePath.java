package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the Service type in your schema. */
public final class ServicePath extends ModelPath<Service> {

  private ServiceCategoryPath category;
  private VetRatingServicePath ratings;

  ServicePath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, Service.class);
  }

  public synchronized ServiceCategoryPath getCategory() {
    if (category == null) {
      category = new ServiceCategoryPath("category", false, this);
    }
    return category;
  }

  public synchronized VetRatingServicePath getRatings() {
    if (ratings == null) {
      ratings = new VetRatingServicePath("ratings", true, this);
    }
    return ratings;
  }
}
