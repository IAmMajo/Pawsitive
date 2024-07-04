package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelProvider;
import com.amplifyframework.util.Immutable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  Contains the set of model classes that implement {@link Model}
 * interface.
 */

public final class AmplifyModelProvider implements ModelProvider {

  private static final String AMPLIFY_MODEL_VERSION =
    "55e555a735b94b9288165589db694fc8";
  private static AmplifyModelProvider amplifyGeneratedModelInstance;

  private AmplifyModelProvider() {}

  public static synchronized AmplifyModelProvider getInstance() {
    if (amplifyGeneratedModelInstance == null) {
      amplifyGeneratedModelInstance = new AmplifyModelProvider();
    }
    return amplifyGeneratedModelInstance;
  }

  /**
   * Get a set of the model classes.
   *
   * @return a set of the model classes.
   */
  @Override
  public Set<Class<? extends Model>> models() {
    final Set<Class<? extends Model>> modifiableSet = new HashSet<>(
      Arrays.<Class<? extends Model>>asList(
        Vet.class,
        Clinic.class,
        VetRating.class,
        ClinicRating.class,
        VetRatingService.class,
        VetRatingPet.class,
        ClinicRatingPet.class,
        Service.class,
        Pet.class,
        ServiceCategory.class
      )
    );

    return Immutable.of(modifiableSet);
  }

  /**
   * Get the version of the models.
   *
   * @return the version string of the models.
   */
  @Override
  public String version() {
    return AMPLIFY_MODEL_VERSION;
  }
}
