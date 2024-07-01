package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the ClinicRating type in your schema. */
public final class ClinicRatingPath extends ModelPath<ClinicRating> {

  private ClinicPath clinic;
  private ClinicRatingPetPath pets;

  ClinicRatingPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, ClinicRating.class);
  }

  public synchronized ClinicPath getClinic() {
    if (clinic == null) {
      clinic = new ClinicPath("clinic", false, this);
    }
    return clinic;
  }

  public synchronized ClinicRatingPetPath getPets() {
    if (pets == null) {
      pets = new ClinicRatingPetPath("pets", true, this);
    }
    return pets;
  }
}
