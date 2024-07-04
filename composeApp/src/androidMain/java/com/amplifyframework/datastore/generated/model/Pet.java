package com.amplifyframework.datastore.generated.model;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

import androidx.core.util.ObjectsCompat;
import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelList;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the Pet type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "Pets",
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
public final class Pet implements Model {

  public static final PetPath rootPath = new PetPath("root", false, null);
  public static final QueryField ID = field("Pet", "id");
  public static final QueryField NAME = field("Pet", "name");
  public static final QueryField IMAGE_PATH = field("Pet", "imagePath");
  public static final QueryField SPECIES = field("Pet", "species");
  public static final QueryField BREED = field("Pet", "breed");
  public static final QueryField BIRTH_DATE = field("Pet", "birthDate");
  public static final QueryField OWNER = field("Pet", "owner");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String name;
  private final @ModelField(targetType = "String") String imagePath;
  private final @ModelField(targetType = "String") String species;
  private final @ModelField(targetType = "String") String breed;
  private final @ModelField(targetType = "AWSDate") Temporal.Date birthDate;
  private final @ModelField(targetType = "VetRatingPet") @HasMany(
    associatedWith = "pet",
    type = VetRatingPet.class
  ) ModelList<VetRatingPet> vetRatings = null;
  private final @ModelField(targetType = "ClinicRatingPet") @HasMany(
    associatedWith = "pet",
    type = ClinicRatingPet.class
  ) ModelList<ClinicRatingPet> clinicRatings = null;
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

  public String getName() {
    return name;
  }

  public String getImagePath() {
    return imagePath;
  }

  public String getSpecies() {
    return species;
  }

  public String getBreed() {
    return breed;
  }

  public Temporal.Date getBirthDate() {
    return birthDate;
  }

  public ModelList<VetRatingPet> getVetRatings() {
    return vetRatings;
  }

  public ModelList<ClinicRatingPet> getClinicRatings() {
    return clinicRatings;
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

  private Pet(
    String id,
    String name,
    String imagePath,
    String species,
    String breed,
    Temporal.Date birthDate,
    String owner
  ) {
    this.id = id;
    this.name = name;
    this.imagePath = imagePath;
    this.species = species;
    this.breed = breed;
    this.birthDate = birthDate;
    this.owner = owner;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      Pet pet = (Pet) obj;
      return (
        ObjectsCompat.equals(getId(), pet.getId()) &&
        ObjectsCompat.equals(getName(), pet.getName()) &&
        ObjectsCompat.equals(getImagePath(), pet.getImagePath()) &&
        ObjectsCompat.equals(getSpecies(), pet.getSpecies()) &&
        ObjectsCompat.equals(getBreed(), pet.getBreed()) &&
        ObjectsCompat.equals(getBirthDate(), pet.getBirthDate()) &&
        ObjectsCompat.equals(getOwner(), pet.getOwner()) &&
        ObjectsCompat.equals(getCreatedAt(), pet.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), pet.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getImagePath())
      .append(getSpecies())
      .append(getBreed())
      .append(getBirthDate())
      .append(getOwner())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("Pet {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("imagePath=" + String.valueOf(getImagePath()) + ", ")
      .append("species=" + String.valueOf(getSpecies()) + ", ")
      .append("breed=" + String.valueOf(getBreed()) + ", ")
      .append("birthDate=" + String.valueOf(getBirthDate()) + ", ")
      .append("owner=" + String.valueOf(getOwner()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }

  public static NameStep builder() {
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
  public static Pet justId(String id) {
    return new Pet(id, null, null, null, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(
      id,
      name,
      imagePath,
      species,
      breed,
      birthDate,
      owner
    );
  }

  public interface NameStep {
    OwnerStep name(String name);
  }

  public interface OwnerStep {
    BuildStep owner(String owner);
  }

  public interface BuildStep {
    Pet build();
    BuildStep id(String id);
    BuildStep imagePath(String imagePath);
    BuildStep species(String species);
    BuildStep breed(String breed);
    BuildStep birthDate(Temporal.Date birthDate);
  }

  public static class Builder implements NameStep, OwnerStep, BuildStep {

    private String id;
    private String name;
    private String owner;
    private String imagePath;
    private String species;
    private String breed;
    private Temporal.Date birthDate;

    public Builder() {}

    private Builder(
      String id,
      String name,
      String imagePath,
      String species,
      String breed,
      Temporal.Date birthDate,
      String owner
    ) {
      this.id = id;
      this.name = name;
      this.imagePath = imagePath;
      this.species = species;
      this.breed = breed;
      this.birthDate = birthDate;
      this.owner = owner;
    }

    @Override
    public Pet build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new Pet(id, name, imagePath, species, breed, birthDate, owner);
    }

    @Override
    public OwnerStep name(String name) {
      Objects.requireNonNull(name);
      this.name = name;
      return this;
    }

    @Override
    public BuildStep owner(String owner) {
      Objects.requireNonNull(owner);
      this.owner = owner;
      return this;
    }

    @Override
    public BuildStep imagePath(String imagePath) {
      this.imagePath = imagePath;
      return this;
    }

    @Override
    public BuildStep species(String species) {
      this.species = species;
      return this;
    }

    @Override
    public BuildStep breed(String breed) {
      this.breed = breed;
      return this;
    }

    @Override
    public BuildStep birthDate(Temporal.Date birthDate) {
      this.birthDate = birthDate;
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
      String name,
      String imagePath,
      String species,
      String breed,
      Temporal.Date birthDate,
      String owner
    ) {
      super(id, name, imagePath, species, breed, birthDate, owner);
      Objects.requireNonNull(name);
      Objects.requireNonNull(owner);
    }

    @Override
    public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }

    @Override
    public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }

    @Override
    public CopyOfBuilder imagePath(String imagePath) {
      return (CopyOfBuilder) super.imagePath(imagePath);
    }

    @Override
    public CopyOfBuilder species(String species) {
      return (CopyOfBuilder) super.species(species);
    }

    @Override
    public CopyOfBuilder breed(String breed) {
      return (CopyOfBuilder) super.breed(breed);
    }

    @Override
    public CopyOfBuilder birthDate(Temporal.Date birthDate) {
      return (CopyOfBuilder) super.birthDate(birthDate);
    }
  }
}
