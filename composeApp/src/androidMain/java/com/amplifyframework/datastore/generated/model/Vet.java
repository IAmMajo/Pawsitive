package com.amplifyframework.datastore.generated.model;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

import androidx.core.util.ObjectsCompat;
import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.LoadedModelReferenceImpl;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelList;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.ModelReference;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;
import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the Vet type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "Vets",
  authRules = {
    @AuthRule(
      allow = AuthStrategy.PUBLIC,
      provider = "iam",
      operations = { ModelOperation.READ }
    ),
  },
  hasLazySupport = true
)
public final class Vet implements Model {

  public static final VetPath rootPath = new VetPath("root", false, null);
  public static final QueryField ID = field("Vet", "id");
  public static final QueryField NAME = field("Vet", "name");
  public static final QueryField IMAGE_PATH = field("Vet", "imagePath");
  public static final QueryField SPECIALIZATION = field(
    "Vet",
    "specialization"
  );
  public static final QueryField CLINIC_ID = field("Vet", "clinicId");
  public static final QueryField CLINIC = field("Vet", "clinicId");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String name;
  private final @ModelField(targetType = "String") String imagePath;
  private final @ModelField(targetType = "String") String specialization;
  private final @ModelField(
    targetType = "ID",
    isRequired = true
  ) String clinicId;
  private final @ModelField(targetType = "Clinic") @BelongsTo(
    targetName = "clinicId",
    type = Clinic.class
  ) ModelReference<Clinic> clinic;
  private final @ModelField(targetType = "VetRating") @HasMany(
    associatedWith = "vet",
    type = VetRating.class
  ) ModelList<VetRating> ratings = null;
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

  public String getSpecialization() {
    return specialization;
  }

  public String getClinicId() {
    return clinicId;
  }

  public ModelReference<Clinic> getClinic() {
    return clinic;
  }

  public ModelList<VetRating> getRatings() {
    return ratings;
  }

  public Temporal.DateTime getCreatedAt() {
    return createdAt;
  }

  public Temporal.DateTime getUpdatedAt() {
    return updatedAt;
  }

  private Vet(
    String id,
    String name,
    String imagePath,
    String specialization,
    String clinicId,
    ModelReference<Clinic> clinic
  ) {
    this.id = id;
    this.name = name;
    this.imagePath = imagePath;
    this.specialization = specialization;
    this.clinicId = clinicId;
    this.clinic = clinic;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      Vet vet = (Vet) obj;
      return (
        ObjectsCompat.equals(getId(), vet.getId()) &&
        ObjectsCompat.equals(getName(), vet.getName()) &&
        ObjectsCompat.equals(getImagePath(), vet.getImagePath()) &&
        ObjectsCompat.equals(getSpecialization(), vet.getSpecialization()) &&
        ObjectsCompat.equals(getClinicId(), vet.getClinicId()) &&
        ObjectsCompat.equals(getClinic(), vet.getClinic()) &&
        ObjectsCompat.equals(getCreatedAt(), vet.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), vet.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getImagePath())
      .append(getSpecialization())
      .append(getClinicId())
      .append(getClinic())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("Vet {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("imagePath=" + String.valueOf(getImagePath()) + ", ")
      .append("specialization=" + String.valueOf(getSpecialization()) + ", ")
      .append("clinicId=" + String.valueOf(getClinicId()) + ", ")
      .append("clinic=" + String.valueOf(getClinic()) + ", ")
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
  public static Vet justId(String id) {
    return new Vet(id, null, null, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(
      id,
      name,
      imagePath,
      specialization,
      clinicId,
      clinic
    );
  }

  public interface NameStep {
    ClinicIdStep name(String name);
  }

  public interface ClinicIdStep {
    BuildStep clinicId(String clinicId);
  }

  public interface BuildStep {
    Vet build();
    BuildStep id(String id);
    BuildStep imagePath(String imagePath);
    BuildStep specialization(String specialization);
    BuildStep clinic(Clinic clinic);
  }

  public static class Builder implements NameStep, ClinicIdStep, BuildStep {

    private String id;
    private String name;
    private String clinicId;
    private String imagePath;
    private String specialization;
    private ModelReference<Clinic> clinic;

    public Builder() {}

    private Builder(
      String id,
      String name,
      String imagePath,
      String specialization,
      String clinicId,
      ModelReference<Clinic> clinic
    ) {
      this.id = id;
      this.name = name;
      this.imagePath = imagePath;
      this.specialization = specialization;
      this.clinicId = clinicId;
      this.clinic = clinic;
    }

    @Override
    public Vet build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new Vet(id, name, imagePath, specialization, clinicId, clinic);
    }

    @Override
    public ClinicIdStep name(String name) {
      Objects.requireNonNull(name);
      this.name = name;
      return this;
    }

    @Override
    public BuildStep clinicId(String clinicId) {
      Objects.requireNonNull(clinicId);
      this.clinicId = clinicId;
      return this;
    }

    @Override
    public BuildStep imagePath(String imagePath) {
      this.imagePath = imagePath;
      return this;
    }

    @Override
    public BuildStep specialization(String specialization) {
      this.specialization = specialization;
      return this;
    }

    @Override
    public BuildStep clinic(Clinic clinic) {
      this.clinic = new LoadedModelReferenceImpl<>(clinic);
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
      String specialization,
      String clinicId,
      ModelReference<Clinic> clinic
    ) {
      super(id, name, imagePath, specialization, clinicId, clinic);
      Objects.requireNonNull(name);
      Objects.requireNonNull(clinicId);
    }

    @Override
    public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }

    @Override
    public CopyOfBuilder clinicId(String clinicId) {
      return (CopyOfBuilder) super.clinicId(clinicId);
    }

    @Override
    public CopyOfBuilder imagePath(String imagePath) {
      return (CopyOfBuilder) super.imagePath(imagePath);
    }

    @Override
    public CopyOfBuilder specialization(String specialization) {
      return (CopyOfBuilder) super.specialization(specialization);
    }

    @Override
    public CopyOfBuilder clinic(Clinic clinic) {
      return (CopyOfBuilder) super.clinic(clinic);
    }
  }
}
