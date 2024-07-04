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

/** This is an auto generated class representing the VetRatingService type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "VetRatingServices",
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
public final class VetRatingService implements Model {

  public static final VetRatingServicePath rootPath = new VetRatingServicePath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("VetRatingService", "id");
  public static final QueryField RATING_ID = field(
    "VetRatingService",
    "ratingId"
  );
  public static final QueryField SERVICE_NUMBER = field(
    "VetRatingService",
    "serviceNumber"
  );
  public static final QueryField RATING = field("VetRatingService", "ratingId");
  public static final QueryField SERVICE = field(
    "VetRatingService",
    "serviceNumber"
  );
  public static final QueryField OWNER = field("VetRatingService", "owner");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "ID",
    isRequired = true
  ) String ratingId;
  private final @ModelField(
    targetType = "ID",
    isRequired = true
  ) String serviceNumber;
  private final @ModelField(targetType = "VetRating") @BelongsTo(
    targetName = "ratingId",
    type = VetRating.class
  ) ModelReference<VetRating> rating;
  private final @ModelField(targetType = "Service") @BelongsTo(
    targetName = "serviceNumber",
    type = Service.class
  ) ModelReference<Service> service;
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

  public String getServiceNumber() {
    return serviceNumber;
  }

  public ModelReference<VetRating> getRating() {
    return rating;
  }

  public ModelReference<Service> getService() {
    return service;
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

  private VetRatingService(
    String id,
    String ratingId,
    String serviceNumber,
    ModelReference<VetRating> rating,
    ModelReference<Service> service,
    String owner
  ) {
    this.id = id;
    this.ratingId = ratingId;
    this.serviceNumber = serviceNumber;
    this.rating = rating;
    this.service = service;
    this.owner = owner;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      VetRatingService vetRatingService = (VetRatingService) obj;
      return (
        ObjectsCompat.equals(getId(), vetRatingService.getId()) &&
        ObjectsCompat.equals(getRatingId(), vetRatingService.getRatingId()) &&
        ObjectsCompat.equals(
          getServiceNumber(),
          vetRatingService.getServiceNumber()
        ) &&
        ObjectsCompat.equals(getRating(), vetRatingService.getRating()) &&
        ObjectsCompat.equals(getService(), vetRatingService.getService()) &&
        ObjectsCompat.equals(getOwner(), vetRatingService.getOwner()) &&
        ObjectsCompat.equals(getCreatedAt(), vetRatingService.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), vetRatingService.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getRatingId())
      .append(getServiceNumber())
      .append(getRating())
      .append(getService())
      .append(getOwner())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("VetRatingService {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("ratingId=" + String.valueOf(getRatingId()) + ", ")
      .append("serviceNumber=" + String.valueOf(getServiceNumber()) + ", ")
      .append("rating=" + String.valueOf(getRating()) + ", ")
      .append("service=" + String.valueOf(getService()) + ", ")
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
  public static VetRatingService justId(String id) {
    return new VetRatingService(id, null, null, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(
      id,
      ratingId,
      serviceNumber,
      rating,
      service,
      owner
    );
  }

  public interface RatingIdStep {
    ServiceNumberStep ratingId(String ratingId);
  }

  public interface ServiceNumberStep {
    OwnerStep serviceNumber(String serviceNumber);
  }

  public interface OwnerStep {
    BuildStep owner(String owner);
  }

  public interface BuildStep {
    VetRatingService build();
    BuildStep id(String id);
    BuildStep rating(VetRating rating);
    BuildStep service(Service service);
  }

  public static class Builder
    implements RatingIdStep, ServiceNumberStep, OwnerStep, BuildStep {

    private String id;
    private String ratingId;
    private String serviceNumber;
    private String owner;
    private ModelReference<VetRating> rating;
    private ModelReference<Service> service;

    public Builder() {}

    private Builder(
      String id,
      String ratingId,
      String serviceNumber,
      ModelReference<VetRating> rating,
      ModelReference<Service> service,
      String owner
    ) {
      this.id = id;
      this.ratingId = ratingId;
      this.serviceNumber = serviceNumber;
      this.rating = rating;
      this.service = service;
      this.owner = owner;
    }

    @Override
    public VetRatingService build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new VetRatingService(
        id,
        ratingId,
        serviceNumber,
        rating,
        service,
        owner
      );
    }

    @Override
    public ServiceNumberStep ratingId(String ratingId) {
      Objects.requireNonNull(ratingId);
      this.ratingId = ratingId;
      return this;
    }

    @Override
    public OwnerStep serviceNumber(String serviceNumber) {
      Objects.requireNonNull(serviceNumber);
      this.serviceNumber = serviceNumber;
      return this;
    }

    @Override
    public BuildStep owner(String owner) {
      Objects.requireNonNull(owner);
      this.owner = owner;
      return this;
    }

    @Override
    public BuildStep rating(VetRating rating) {
      this.rating = new LoadedModelReferenceImpl<>(rating);
      return this;
    }

    @Override
    public BuildStep service(Service service) {
      this.service = new LoadedModelReferenceImpl<>(service);
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
      String serviceNumber,
      ModelReference<VetRating> rating,
      ModelReference<Service> service,
      String owner
    ) {
      super(id, ratingId, serviceNumber, rating, service, owner);
      Objects.requireNonNull(ratingId);
      Objects.requireNonNull(serviceNumber);
      Objects.requireNonNull(owner);
    }

    @Override
    public CopyOfBuilder ratingId(String ratingId) {
      return (CopyOfBuilder) super.ratingId(ratingId);
    }

    @Override
    public CopyOfBuilder serviceNumber(String serviceNumber) {
      return (CopyOfBuilder) super.serviceNumber(serviceNumber);
    }

    @Override
    public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }

    @Override
    public CopyOfBuilder rating(VetRating rating) {
      return (CopyOfBuilder) super.rating(rating);
    }

    @Override
    public CopyOfBuilder service(Service service) {
      return (CopyOfBuilder) super.service(service);
    }
  }
}
