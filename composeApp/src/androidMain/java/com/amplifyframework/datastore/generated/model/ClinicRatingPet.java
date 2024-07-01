package com.amplifyframework.datastore.generated.model;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

import androidx.core.util.ObjectsCompat;
import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.LoadedModelReferenceImpl;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.ModelReference;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the ClinicRatingPet type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "ClinicRatingPets",
  authRules = {
    @AuthRule(
      allow = AuthStrategy.PUBLIC,
      provider = "iam",
      operations = { ModelOperation.READ }
    ),
    @AuthRule(
      allow = AuthStrategy.OWNER,
      ownerField = "owner",
      identityClaim = "cognito:username",
      provider = "userPools",
      operations = {
        ModelOperation.CREATE,
        ModelOperation.UPDATE,
        ModelOperation.DELETE,
        ModelOperation.READ,
      }
    ),
  },
  hasLazySupport = true
)
public final class ClinicRatingPet implements Model {

  public static final ClinicRatingPetPath rootPath = new ClinicRatingPetPath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("ClinicRatingPet", "id");
  public static final QueryField RATING_ID = field(
    "ClinicRatingPet",
    "ratingId"
  );
  public static final QueryField PET_ID = field("ClinicRatingPet", "petId");
  public static final QueryField RATING = field("ClinicRatingPet", "ratingId");
  public static final QueryField PET = field("ClinicRatingPet", "petId");
  public static final QueryField OWNER = field("ClinicRatingPet", "owner");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "ID",
    isRequired = true
  ) String ratingId;
  private final @ModelField(targetType = "ID", isRequired = true) String petId;
  private final @ModelField(targetType = "ClinicRating") @BelongsTo(
    targetName = "ratingId",
    type = ClinicRating.class
  ) ModelReference<ClinicRating> rating;
  private final @ModelField(targetType = "Pet") @BelongsTo(
    targetName = "petId",
    type = Pet.class
  ) ModelReference<Pet> pet;
  private final @ModelField(
    targetType = "String",
    isRequired = true,
    authRules = {
      @AuthRule(
        allow = AuthStrategy.PUBLIC,
        provider = "iam",
        operations = { ModelOperation.READ }
      ),
      @AuthRule(
        allow = AuthStrategy.OWNER,
        ownerField = "owner",
        identityClaim = "cognito:username",
        provider = "userPools",
        operations = { ModelOperation.READ, ModelOperation.DELETE }
      ),
    }
  ) String owner;
  private @ModelField(
    targetType = "AWSDateTime",
    isReadOnly = true
  ) Temporal.DateTime createdAt;
  private @ModelField(
    targetType = "AWSDateTime",
    isReadOnly = true
  ) Temporal.DateTime updatedAt;

  public String getId() {
    return id;
  }

  public String getRatingId() {
    return ratingId;
  }

  public String getPetId() {
    return petId;
  }

  public ModelReference<ClinicRating> getRating() {
    return rating;
  }

  public ModelReference<Pet> getPet() {
    return pet;
  }

  public String getOwner() {
    return owner;
  }

  public Temporal.DateTime getCreatedAt() {
    return createdAt;
  }

  public Temporal.DateTime getUpdatedAt() {
    return updatedAt;
  }

  private ClinicRatingPet(
    String id,
    String ratingId,
    String petId,
    ModelReference<ClinicRating> rating,
    ModelReference<Pet> pet,
    String owner
  ) {
    this.id = id;
    this.ratingId = ratingId;
    this.petId = petId;
    this.rating = rating;
    this.pet = pet;
    this.owner = owner;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      ClinicRatingPet clinicRatingPet = (ClinicRatingPet) obj;
      return (
        ObjectsCompat.equals(getId(), clinicRatingPet.getId()) &&
        ObjectsCompat.equals(getRatingId(), clinicRatingPet.getRatingId()) &&
        ObjectsCompat.equals(getPetId(), clinicRatingPet.getPetId()) &&
        ObjectsCompat.equals(getRating(), clinicRatingPet.getRating()) &&
        ObjectsCompat.equals(getPet(), clinicRatingPet.getPet()) &&
        ObjectsCompat.equals(getOwner(), clinicRatingPet.getOwner()) &&
        ObjectsCompat.equals(getCreatedAt(), clinicRatingPet.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), clinicRatingPet.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getRatingId())
      .append(getPetId())
      .append(getRating())
      .append(getPet())
      .append(getOwner())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("ClinicRatingPet {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("ratingId=" + String.valueOf(getRatingId()) + ", ")
      .append("petId=" + String.valueOf(getPetId()) + ", ")
      .append("rating=" + String.valueOf(getRating()) + ", ")
      .append("pet=" + String.valueOf(getPet()) + ", ")
      .append("owner=" + String.valueOf(getOwner()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }

  public static RatingIdStep builder() {
    return new Builder();
  }

  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static ClinicRatingPet justId(String id) {
    return new ClinicRatingPet(id, null, null, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id, ratingId, petId, rating, pet, owner);
  }

  public interface RatingIdStep {
    PetIdStep ratingId(String ratingId);
  }

  public interface PetIdStep {
    OwnerStep petId(String petId);
  }

  public interface OwnerStep {
    BuildStep owner(String owner);
  }

  public interface BuildStep {
    ClinicRatingPet build();
    BuildStep id(String id);
    BuildStep rating(ClinicRating rating);
    BuildStep pet(Pet pet);
  }

  public static class Builder
    implements RatingIdStep, PetIdStep, OwnerStep, BuildStep {

    private String id;
    private String ratingId;
    private String petId;
    private String owner;
    private ModelReference<ClinicRating> rating;
    private ModelReference<Pet> pet;

    public Builder() {}

    private Builder(
      String id,
      String ratingId,
      String petId,
      ModelReference<ClinicRating> rating,
      ModelReference<Pet> pet,
      String owner
    ) {
      this.id = id;
      this.ratingId = ratingId;
      this.petId = petId;
      this.rating = rating;
      this.pet = pet;
      this.owner = owner;
    }

    @Override
    public ClinicRatingPet build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new ClinicRatingPet(id, ratingId, petId, rating, pet, owner);
    }

    @Override
    public PetIdStep ratingId(String ratingId) {
      Objects.requireNonNull(ratingId);
      this.ratingId = ratingId;
      return this;
    }

    @Override
    public OwnerStep petId(String petId) {
      Objects.requireNonNull(petId);
      this.petId = petId;
      return this;
    }

    @Override
    public BuildStep owner(String owner) {
      Objects.requireNonNull(owner);
      this.owner = owner;
      return this;
    }

    @Override
    public BuildStep rating(ClinicRating rating) {
      this.rating = new LoadedModelReferenceImpl<>(rating);
      return this;
    }

    @Override
    public BuildStep pet(Pet pet) {
      this.pet = new LoadedModelReferenceImpl<>(pet);
      return this;
    }

    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
      this.id = id;
      return this;
    }
  }

  public final class CopyOfBuilder extends Builder {

    private CopyOfBuilder(
      String id,
      String ratingId,
      String petId,
      ModelReference<ClinicRating> rating,
      ModelReference<Pet> pet,
      String owner
    ) {
      super(id, ratingId, petId, rating, pet, owner);
      Objects.requireNonNull(ratingId);
      Objects.requireNonNull(petId);
      Objects.requireNonNull(owner);
    }

    @Override
    public CopyOfBuilder ratingId(String ratingId) {
      return (CopyOfBuilder) super.ratingId(ratingId);
    }

    @Override
    public CopyOfBuilder petId(String petId) {
      return (CopyOfBuilder) super.petId(petId);
    }

    @Override
    public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }

    @Override
    public CopyOfBuilder rating(ClinicRating rating) {
      return (CopyOfBuilder) super.rating(rating);
    }

    @Override
    public CopyOfBuilder pet(Pet pet) {
      return (CopyOfBuilder) super.pet(pet);
    }
  }
}
