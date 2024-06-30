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
import java.util.Objects;
import java.util.UUID;

/** This is an auto generated class representing the Service type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "Services",
  authRules = {
    @AuthRule(
      allow = AuthStrategy.PUBLIC,
      provider = "iam",
      operations = { ModelOperation.READ }
    ),
  },
  hasLazySupport = true
)
@Index(name = "undefined", fields = { "number" })
public final class Service implements Model {

  public static final ServicePath rootPath = new ServicePath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("Service", "id");
  public static final QueryField NUMBER = field("Service", "number");
  public static final QueryField NAME = field("Service", "name");
  public static final QueryField CATEGORY_ID = field("Service", "categoryId");
  public static final QueryField CATEGORY = field("Service", "categoryId");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String number;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String name;
  private final @ModelField(
    targetType = "ID",
    isRequired = true
  ) String categoryId;
  private final @ModelField(targetType = "ServiceCategory") @BelongsTo(
    targetName = "categoryId",
    type = ServiceCategory.class
  ) ModelReference<ServiceCategory> category;
  private final @ModelField(targetType = "VetRatingService") @HasMany(
    associatedWith = "service",
    type = VetRatingService.class
  ) ModelList<VetRatingService> ratings = null;
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

  public String getNumber() {
    return number;
  }

  public String getName() {
    return name;
  }

  public String getCategoryId() {
    return categoryId;
  }

  public ModelReference<ServiceCategory> getCategory() {
    return category;
  }

  public ModelList<VetRatingService> getRatings() {
    return ratings;
  }

  public Temporal.DateTime getCreatedAt() {
    return createdAt;
  }

  public Temporal.DateTime getUpdatedAt() {
    return updatedAt;
  }

  private Service(
    String id,
    String number,
    String name,
    String categoryId,
    ModelReference<ServiceCategory> category
  ) {
    this.id = id;
    this.number = number;
    this.name = name;
    this.categoryId = categoryId;
    this.category = category;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      Service service = (Service) obj;
      return (
        ObjectsCompat.equals(getId(), service.getId()) &&
        ObjectsCompat.equals(getNumber(), service.getNumber()) &&
        ObjectsCompat.equals(getName(), service.getName()) &&
        ObjectsCompat.equals(getCategoryId(), service.getCategoryId()) &&
        ObjectsCompat.equals(getCategory(), service.getCategory()) &&
        ObjectsCompat.equals(getCreatedAt(), service.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), service.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getNumber())
      .append(getName())
      .append(getCategoryId())
      .append(getCategory())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("Service {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("number=" + String.valueOf(getNumber()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("categoryId=" + String.valueOf(getCategoryId()) + ", ")
      .append("category=" + String.valueOf(getCategory()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }

  public static NumberStep builder() {
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
  public static Service justId(String id) {
    return new Service(id, null, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id, number, name, categoryId, category);
  }

  public interface NumberStep {
    NameStep number(String number);
  }

  public interface NameStep {
    CategoryIdStep name(String name);
  }

  public interface CategoryIdStep {
    BuildStep categoryId(String categoryId);
  }

  public interface BuildStep {
    Service build();
    BuildStep id(String id);
    BuildStep category(ServiceCategory category);
  }

  public static class Builder
    implements NumberStep, NameStep, CategoryIdStep, BuildStep {

    private String id;
    private String number;
    private String name;
    private String categoryId;
    private ModelReference<ServiceCategory> category;

    public Builder() {}

    private Builder(
      String id,
      String number,
      String name,
      String categoryId,
      ModelReference<ServiceCategory> category
    ) {
      this.id = id;
      this.number = number;
      this.name = name;
      this.categoryId = categoryId;
      this.category = category;
    }

    @Override
    public Service build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new Service(id, number, name, categoryId, category);
    }

    @Override
    public NameStep number(String number) {
      Objects.requireNonNull(number);
      this.number = number;
      return this;
    }

    @Override
    public CategoryIdStep name(String name) {
      Objects.requireNonNull(name);
      this.name = name;
      return this;
    }

    @Override
    public BuildStep categoryId(String categoryId) {
      Objects.requireNonNull(categoryId);
      this.categoryId = categoryId;
      return this;
    }

    @Override
    public BuildStep category(ServiceCategory category) {
      this.category = new LoadedModelReferenceImpl<>(category);
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
      String number,
      String name,
      String categoryId,
      ModelReference<ServiceCategory> category
    ) {
      super(id, number, name, categoryId, category);
      Objects.requireNonNull(number);
      Objects.requireNonNull(name);
      Objects.requireNonNull(categoryId);
    }

    @Override
    public CopyOfBuilder number(String number) {
      return (CopyOfBuilder) super.number(number);
    }

    @Override
    public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }

    @Override
    public CopyOfBuilder categoryId(String categoryId) {
      return (CopyOfBuilder) super.categoryId(categoryId);
    }

    @Override
    public CopyOfBuilder category(ServiceCategory category) {
      return (CopyOfBuilder) super.category(category);
    }
  }
}
