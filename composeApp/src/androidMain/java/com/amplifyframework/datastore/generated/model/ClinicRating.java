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

/** This is an auto generated class representing the ClinicRating type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "ClinicRatings",
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
public final class ClinicRating implements Model {

  public static final ClinicRatingPath rootPath = new ClinicRatingPath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("ClinicRating", "id");
  public static final QueryField CLINIC_ID = field("ClinicRating", "clinicId");
  public static final QueryField RATING = field("ClinicRating", "rating");
  public static final QueryField COMMENT = field("ClinicRating", "comment");
  public static final QueryField CLINIC = field("ClinicRating", "clinicId");
  public static final QueryField OWNER = field("ClinicRating", "owner");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "ID",
    isRequired = true
  ) String clinicId;
  private final @ModelField(targetType = "Float") Double rating;
  private final @ModelField(targetType = "String") String comment;
  private final @ModelField(targetType = "Clinic") @BelongsTo(
    targetName = "clinicId",
    type = Clinic.class
  ) ModelReference<Clinic> clinic;
  private final @ModelField(targetType = "ClinicRatingPet") @HasMany(
    associatedWith = "rating",
    type = ClinicRatingPet.class
  ) ModelList<ClinicRatingPet> pets = null;
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

  public String getClinicId() {
    return clinicId;
  }

  public Double getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }

  public ModelReference<Clinic> getClinic() {
    return clinic;
  }

  public ModelList<ClinicRatingPet> getPets() {
    return pets;
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

  private ClinicRating(
    String id,
    String clinicId,
    Double rating,
    String comment,
    ModelReference<Clinic> clinic,
    String owner
  ) {
    this.id = id;
    this.clinicId = clinicId;
    this.rating = rating;
    this.comment = comment;
    this.clinic = clinic;
    this.owner = owner;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      ClinicRating clinicRating = (ClinicRating) obj;
      return (
        ObjectsCompat.equals(getId(), clinicRating.getId()) &&
        ObjectsCompat.equals(getClinicId(), clinicRating.getClinicId()) &&
        ObjectsCompat.equals(getRating(), clinicRating.getRating()) &&
        ObjectsCompat.equals(getComment(), clinicRating.getComment()) &&
        ObjectsCompat.equals(getClinic(), clinicRating.getClinic()) &&
        ObjectsCompat.equals(getOwner(), clinicRating.getOwner()) &&
        ObjectsCompat.equals(getCreatedAt(), clinicRating.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), clinicRating.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getClinicId())
      .append(getRating())
      .append(getComment())
      .append(getClinic())
      .append(getOwner())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("ClinicRating {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("clinicId=" + String.valueOf(getClinicId()) + ", ")
      .append("rating=" + String.valueOf(getRating()) + ", ")
      .append("comment=" + String.valueOf(getComment()) + ", ")
      .append("clinic=" + String.valueOf(getClinic()) + ", ")
      .append("owner=" + String.valueOf(getOwner()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }

  public static ClinicIdStep builder() {
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
  public static ClinicRating justId(String id) {
    return new ClinicRating(id, null, null, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id, clinicId, rating, comment, clinic, owner);
  }

  public interface ClinicIdStep {
    OwnerStep clinicId(String clinicId);
  }

  public interface OwnerStep {
    BuildStep owner(String owner);
  }

  public interface BuildStep {
    ClinicRating build();
    BuildStep id(String id);
    BuildStep rating(Double rating);
    BuildStep comment(String comment);
    BuildStep clinic(Clinic clinic);
  }

  public static class Builder implements ClinicIdStep, OwnerStep, BuildStep {

    private String id;
    private String clinicId;
    private String owner;
    private Double rating;
    private String comment;
    private ModelReference<Clinic> clinic;

    public Builder() {}

    private Builder(
      String id,
      String clinicId,
      Double rating,
      String comment,
      ModelReference<Clinic> clinic,
      String owner
    ) {
      this.id = id;
      this.clinicId = clinicId;
      this.rating = rating;
      this.comment = comment;
      this.clinic = clinic;
      this.owner = owner;
    }

    @Override
    public ClinicRating build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new ClinicRating(id, clinicId, rating, comment, clinic, owner);
    }

    @Override
    public OwnerStep clinicId(String clinicId) {
      Objects.requireNonNull(clinicId);
      this.clinicId = clinicId;
      return this;
    }

    @Override
    public BuildStep owner(String owner) {
      Objects.requireNonNull(owner);
      this.owner = owner;
      return this;
    }

    @Override
    public BuildStep rating(Double rating) {
      this.rating = rating;
      return this;
    }

    @Override
    public BuildStep comment(String comment) {
      this.comment = comment;
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
      String clinicId,
      Double rating,
      String comment,
      ModelReference<Clinic> clinic,
      String owner
    ) {
      super(id, clinicId, rating, comment, clinic, owner);
      Objects.requireNonNull(clinicId);
      Objects.requireNonNull(owner);
    }

    @Override
    public CopyOfBuilder clinicId(String clinicId) {
      return (CopyOfBuilder) super.clinicId(clinicId);
    }

    @Override
    public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }

    @Override
    public CopyOfBuilder rating(Double rating) {
      return (CopyOfBuilder) super.rating(rating);
    }

    @Override
    public CopyOfBuilder comment(String comment) {
      return (CopyOfBuilder) super.comment(comment);
    }

    @Override
    public CopyOfBuilder clinic(Clinic clinic) {
      return (CopyOfBuilder) super.clinic(clinic);
    }
  }
}
