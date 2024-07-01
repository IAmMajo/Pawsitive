package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the VetRatingPet type in your schema. */
public final class VetRatingPetPath extends ModelPath<VetRatingPet> {

  private VetRatingPath rating;
  private PetPath pet;

  VetRatingPetPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, VetRatingPet.class);
  }

  public synchronized VetRatingPath getRating() {
    if (rating == null) {
      rating = new VetRatingPath("rating", false, this);
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
