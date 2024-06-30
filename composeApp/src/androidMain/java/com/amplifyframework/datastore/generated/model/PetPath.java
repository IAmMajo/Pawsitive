package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the Pet type in your schema. */
public final class PetPath extends ModelPath<Pet> {

  private VetRatingPetPath vetRatings;
  private ClinicRatingPetPath clinicRatings;

  PetPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, Pet.class);
  }

  public synchronized VetRatingPetPath getVetRatings() {
    if (vetRatings == null) {
      vetRatings = new VetRatingPetPath("vetRatings", true, this);
    }
    return vetRatings;
  }

  public synchronized ClinicRatingPetPath getClinicRatings() {
    if (clinicRatings == null) {
      clinicRatings = new ClinicRatingPetPath("clinicRatings", true, this);
    }
    return clinicRatings;
  }
}
