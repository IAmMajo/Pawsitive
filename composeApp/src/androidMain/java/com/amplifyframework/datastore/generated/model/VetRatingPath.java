package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the VetRating type in your schema. */
public final class VetRatingPath extends ModelPath<VetRating> {

  private VetPath vet;
  private VetRatingServicePath services;
  private VetRatingPetPath pets;

  VetRatingPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, VetRating.class);
  }

  public synchronized VetPath getVet() {
    if (vet == null) {
      vet = new VetPath("vet", false, this);
    }
    return vet;
  }

  public synchronized VetRatingServicePath getServices() {
    if (services == null) {
      services = new VetRatingServicePath("services", true, this);
    }
    return services;
  }

  public synchronized VetRatingPetPath getPets() {
    if (pets == null) {
      pets = new VetRatingPetPath("pets", true, this);
    }
    return pets;
  }
}
