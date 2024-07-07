package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the Favorite type in your schema. */
public final class FavoritePath extends ModelPath<Favorite> {

  private VetPath vet;

  FavoritePath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, Favorite.class);
  }

  public synchronized VetPath getVet() {
    if (vet == null) {
      vet = new VetPath("vet", false, this);
    }
    return vet;
  }
}
