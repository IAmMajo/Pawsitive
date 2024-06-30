package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the Vet type in your schema. */
public final class VetPath extends ModelPath<Vet> {

  private ClinicPath clinic;
  private VetRatingPath ratings;

  VetPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, Vet.class);
  }

  public synchronized ClinicPath getClinic() {
    if (clinic == null) {
      clinic = new ClinicPath("clinic", false, this);
    }
    return clinic;
  }

  public synchronized VetRatingPath getRatings() {
    if (ratings == null) {
      ratings = new VetRatingPath("ratings", true, this);
    }
    return ratings;
  }
}
