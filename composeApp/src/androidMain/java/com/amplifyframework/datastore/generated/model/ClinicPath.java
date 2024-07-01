package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the Clinic type in your schema. */
public final class ClinicPath extends ModelPath<Clinic> {

  private VetPath vets;
  private ClinicRatingPath ratings;

  ClinicPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, Clinic.class);
  }

  public synchronized VetPath getVets() {
    if (vets == null) {
      vets = new VetPath("vets", true, this);
    }
    return vets;
  }

  public synchronized ClinicRatingPath getRatings() {
    if (ratings == null) {
      ratings = new ClinicRatingPath("ratings", true, this);
    }
    return ratings;
  }
}
