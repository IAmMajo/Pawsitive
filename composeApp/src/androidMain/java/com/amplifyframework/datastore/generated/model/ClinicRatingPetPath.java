package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the ClinicRatingPet type in your schema. */
public final class ClinicRatingPetPath extends ModelPath<ClinicRatingPet> {

  private ClinicRatingPath rating;
  private PetPath pet;

  ClinicRatingPetPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, ClinicRatingPet.class);
  }

  public synchronized ClinicRatingPath getRating() {
    if (rating == null) {
      rating = new ClinicRatingPath("rating", false, this);
    }
    return rating;
  }

  public synchronized PetPath getPet() {
    if (pet == null) {
      pet = new PetPath("pet", false, this);
    }
    return pet;
  }
}
