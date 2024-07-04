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
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;
import com.amplifyframework.core.model.temporal.Temporal;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the VetRating type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "VetRatings",
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
public final class VetRating implements Model {

  public static final VetRatingPath rootPath = new VetRatingPath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("VetRating", "id");
  public static final QueryField VET_ID = field("VetRating", "vetId");
  public static final QueryField RATING_DIAGNOSIS = field(
    "VetRating",
    "ratingDiagnosis"
  );
  public static final QueryField RATING_TREATMENT = field(
    "VetRating",
    "ratingTreatment"
  );
  public static final QueryField RATING_INFORMATION = field(
    "VetRating",
    "ratingInformation"
  );
  public static final QueryField RATING_TRUST = field(
    "VetRating",
    "ratingTrust"
  );
  public static final QueryField RATING_INVESTED_TIME = field(
    "VetRating",
    "ratingInvestedTime"
  );
  public static final QueryField RATING_FRIENDLINESS = field(
    "VetRating",
    "ratingFriendliness"
  );
  public static final QueryField COMMENT = field("VetRating", "comment");
  public static final QueryField VET = field("VetRating", "vetId");
  public static final QueryField OWNER = field("VetRating", "owner");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(targetType = "ID", isRequired = true) String vetId;
  private final @ModelField(
    targetType = "Int",
    isRequired = true
  ) Integer ratingDiagnosis;
  private final @ModelField(
    targetType = "Int",
    isRequired = true
  ) Integer ratingTreatment;
  private final @ModelField(
    targetType = "Int",
    isRequired = true
  ) Integer ratingInformation;
  private final @ModelField(targetType = "Int") Integer ratingTrust;
  private final @ModelField(targetType = "Int") Integer ratingInvestedTime;
  private final @ModelField(targetType = "Int") Integer ratingFriendliness;
  private final @ModelField(targetType = "String") String comment;
  private final @ModelField(targetType = "Vet") @BelongsTo(
    targetName = "vetId",
    type = Vet.class
  ) ModelReference<Vet> vet;
  private final @ModelField(targetType = "VetRatingService") @HasMany(
    associatedWith = "rating",
    type = VetRatingService.class
  ) ModelList<VetRatingService> services = null;
  private final @ModelField(targetType = "VetRatingPet") @HasMany(
    associatedWith = "rating",
    type = VetRatingPet.class
  ) ModelList<VetRatingPet> pets = null;
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

  public String getVetId() {
    return vetId;
  }

  public Integer getRatingDiagnosis() {
    return ratingDiagnosis;
  }

  public Integer getRatingTreatment() {
    return ratingTreatment;
  }

  public Integer getRatingInformation() {
    return ratingInformation;
  }

  public Integer getRatingTrust() {
    return ratingTrust;
  }

  public Integer getRatingInvestedTime() {
    return ratingInvestedTime;
  }

  public Integer getRatingFriendliness() {
    return ratingFriendliness;
  }

  public String getComment() {
    return comment;
  }

  public ModelReference<Vet> getVet() {
    return vet;
  }

  public ModelList<VetRatingService> getServices() {
    return services;
  }

  public ModelList<VetRatingPet> getPets() {
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

  private VetRating(
    String id,
    String vetId,
    Integer ratingDiagnosis,
    Integer ratingTreatment,
    Integer ratingInformation,
    Integer ratingTrust,
    Integer ratingInvestedTime,
    Integer ratingFriendliness,
    String comment,
    ModelReference<Vet> vet,
    String owner
  ) {
    this.id = id;
    this.vetId = vetId;
    this.ratingDiagnosis = ratingDiagnosis;
    this.ratingTreatment = ratingTreatment;
    this.ratingInformation = ratingInformation;
    this.ratingTrust = ratingTrust;
    this.ratingInvestedTime = ratingInvestedTime;
    this.ratingFriendliness = ratingFriendliness;
    this.comment = comment;
    this.vet = vet;
    this.owner = owner;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      VetRating vetRating = (VetRating) obj;
      return (
        ObjectsCompat.equals(getId(), vetRating.getId()) &&
        ObjectsCompat.equals(getVetId(), vetRating.getVetId()) &&
        ObjectsCompat.equals(
          getRatingDiagnosis(),
          vetRating.getRatingDiagnosis()
        ) &&
        ObjectsCompat.equals(
          getRatingTreatment(),
          vetRating.getRatingTreatment()
        ) &&
        ObjectsCompat.equals(
          getRatingInformation(),
          vetRating.getRatingInformation()
        ) &&
        ObjectsCompat.equals(getRatingTrust(), vetRating.getRatingTrust()) &&
        ObjectsCompat.equals(
          getRatingInvestedTime(),
          vetRating.getRatingInvestedTime()
        ) &&
        ObjectsCompat.equals(
          getRatingFriendliness(),
          vetRating.getRatingFriendliness()
        ) &&
        ObjectsCompat.equals(getComment(), vetRating.getComment()) &&
        ObjectsCompat.equals(getVet(), vetRating.getVet()) &&
        ObjectsCompat.equals(getOwner(), vetRating.getOwner()) &&
        ObjectsCompat.equals(getCreatedAt(), vetRating.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), vetRating.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getVetId())
      .append(getRatingDiagnosis())
      .append(getRatingTreatment())
      .append(getRatingInformation())
      .append(getRatingTrust())
      .append(getRatingInvestedTime())
      .append(getRatingFriendliness())
      .append(getComment())
      .append(getVet())
      .append(getOwner())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("VetRating {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("vetId=" + String.valueOf(getVetId()) + ", ")
      .append("ratingDiagnosis=" + String.valueOf(getRatingDiagnosis()) + ", ")
      .append("ratingTreatment=" + String.valueOf(getRatingTreatment()) + ", ")
      .append(
        "ratingInformation=" + String.valueOf(getRatingInformation()) + ", "
      )
      .append("ratingTrust=" + String.valueOf(getRatingTrust()) + ", ")
      .append(
        "ratingInvestedTime=" + String.valueOf(getRatingInvestedTime()) + ", "
      )
      .append(
        "ratingFriendliness=" + String.valueOf(getRatingFriendliness()) + ", "
      )
      .append("comment=" + String.valueOf(getComment()) + ", ")
      .append("vet=" + String.valueOf(getVet()) + ", ")
      .append("owner=" + String.valueOf(getOwner()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }

  public static VetIdStep builder() {
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
  public static VetRating justId(String id) {
    return new VetRating(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(
      id,
      vetId,
      ratingDiagnosis,
      ratingTreatment,
      ratingInformation,
      ratingTrust,
      ratingInvestedTime,
      ratingFriendliness,
      comment,
      vet,
      owner
    );
  }

  public interface VetIdStep {
    RatingDiagnosisStep vetId(String vetId);
  }

  public interface RatingDiagnosisStep {
    RatingTreatmentStep ratingDiagnosis(Integer ratingDiagnosis);
  }

  public interface RatingTreatmentStep {
    RatingInformationStep ratingTreatment(Integer ratingTreatment);
  }

  public interface RatingInformationStep {
    OwnerStep ratingInformation(Integer ratingInformation);
  }

  public interface OwnerStep {
    BuildStep owner(String owner);
  }

  public interface BuildStep {
    VetRating build();
    BuildStep id(String id);
    BuildStep ratingTrust(Integer ratingTrust);
    BuildStep ratingInvestedTime(Integer ratingInvestedTime);
    BuildStep ratingFriendliness(Integer ratingFriendliness);
    BuildStep comment(String comment);
    BuildStep vet(Vet vet);
  }

  public static class Builder
    implements
      VetIdStep,
      RatingDiagnosisStep,
      RatingTreatmentStep,
      RatingInformationStep,
      OwnerStep,
      BuildStep {

    private String id;
    private String vetId;
    private Integer ratingDiagnosis;
    private Integer ratingTreatment;
    private Integer ratingInformation;
    private String owner;
    private Integer ratingTrust;
    private Integer ratingInvestedTime;
    private Integer ratingFriendliness;
    private String comment;
    private ModelReference<Vet> vet;

    public Builder() {}

    private Builder(
      String id,
      String vetId,
      Integer ratingDiagnosis,
      Integer ratingTreatment,
      Integer ratingInformation,
      Integer ratingTrust,
      Integer ratingInvestedTime,
      Integer ratingFriendliness,
      String comment,
      ModelReference<Vet> vet,
      String owner
    ) {
      this.id = id;
      this.vetId = vetId;
      this.ratingDiagnosis = ratingDiagnosis;
      this.ratingTreatment = ratingTreatment;
      this.ratingInformation = ratingInformation;
      this.ratingTrust = ratingTrust;
      this.ratingInvestedTime = ratingInvestedTime;
      this.ratingFriendliness = ratingFriendliness;
      this.comment = comment;
      this.vet = vet;
      this.owner = owner;
    }

    @Override
    public VetRating build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new VetRating(
        id,
        vetId,
        ratingDiagnosis,
        ratingTreatment,
        ratingInformation,
        ratingTrust,
        ratingInvestedTime,
        ratingFriendliness,
        comment,
        vet,
        owner
      );
    }

    @Override
    public RatingDiagnosisStep vetId(String vetId) {
      Objects.requireNonNull(vetId);
      this.vetId = vetId;
      return this;
    }

    @Override
    public RatingTreatmentStep ratingDiagnosis(Integer ratingDiagnosis) {
      Objects.requireNonNull(ratingDiagnosis);
      this.ratingDiagnosis = ratingDiagnosis;
      return this;
    }

    @Override
    public RatingInformationStep ratingTreatment(Integer ratingTreatment) {
      Objects.requireNonNull(ratingTreatment);
      this.ratingTreatment = ratingTreatment;
      return this;
    }

    @Override
    public OwnerStep ratingInformation(Integer ratingInformation) {
      Objects.requireNonNull(ratingInformation);
      this.ratingInformation = ratingInformation;
      return this;
    }

    @Override
    public BuildStep owner(String owner) {
      Objects.requireNonNull(owner);
      this.owner = owner;
      return this;
    }

    @Override
    public BuildStep ratingTrust(Integer ratingTrust) {
      this.ratingTrust = ratingTrust;
      return this;
    }

    @Override
    public BuildStep ratingInvestedTime(Integer ratingInvestedTime) {
      this.ratingInvestedTime = ratingInvestedTime;
      return this;
    }

    @Override
    public BuildStep ratingFriendliness(Integer ratingFriendliness) {
      this.ratingFriendliness = ratingFriendliness;
      return this;
    }

    @Override
    public BuildStep comment(String comment) {
      this.comment = comment;
      return this;
    }

    @Override
    public BuildStep vet(Vet vet) {
      this.vet = new LoadedModelReferenceImpl<>(vet);
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
      String vetId,
      Integer ratingDiagnosis,
      Integer ratingTreatment,
      Integer ratingInformation,
      Integer ratingTrust,
      Integer ratingInvestedTime,
      Integer ratingFriendliness,
      String comment,
      ModelReference<Vet> vet,
      String owner
    ) {
      super(
        id,
        vetId,
        ratingDiagnosis,
        ratingTreatment,
        ratingInformation,
        ratingTrust,
        ratingInvestedTime,
        ratingFriendliness,
        comment,
        vet,
        owner
      );
      Objects.requireNonNull(vetId);
      Objects.requireNonNull(ratingDiagnosis);
      Objects.requireNonNull(ratingTreatment);
      Objects.requireNonNull(ratingInformation);
      Objects.requireNonNull(owner);
    }

    @Override
    public CopyOfBuilder vetId(String vetId) {
      return (CopyOfBuilder) super.vetId(vetId);
    }

    @Override
    public CopyOfBuilder ratingDiagnosis(Integer ratingDiagnosis) {
      return (CopyOfBuilder) super.ratingDiagnosis(ratingDiagnosis);
    }

    @Override
    public CopyOfBuilder ratingTreatment(Integer ratingTreatment) {
      return (CopyOfBuilder) super.ratingTreatment(ratingTreatment);
    }

    @Override
    public CopyOfBuilder ratingInformation(Integer ratingInformation) {
      return (CopyOfBuilder) super.ratingInformation(ratingInformation);
    }

    @Override
    public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }

    @Override
    public CopyOfBuilder ratingTrust(Integer ratingTrust) {
      return (CopyOfBuilder) super.ratingTrust(ratingTrust);
    }

    @Override
    public CopyOfBuilder ratingInvestedTime(Integer ratingInvestedTime) {
      return (CopyOfBuilder) super.ratingInvestedTime(ratingInvestedTime);
    }

    @Override
    public CopyOfBuilder ratingFriendliness(Integer ratingFriendliness) {
      return (CopyOfBuilder) super.ratingFriendliness(ratingFriendliness);
    }

    @Override
    public CopyOfBuilder comment(String comment) {
      return (CopyOfBuilder) super.comment(comment);
    }

    @Override
    public CopyOfBuilder vet(Vet vet) {
      return (CopyOfBuilder) super.vet(vet);
    }
  }
}
