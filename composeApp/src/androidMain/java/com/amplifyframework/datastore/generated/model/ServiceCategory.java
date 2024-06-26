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

/** This is an auto generated class representing the ServiceCategory type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "ServiceCategories",
  authRules = {
    @AuthRule(
      allow = AuthStrategy.PUBLIC,
      provider = "iam",
      operations = { ModelOperation.READ }
    ),
  },
  hasLazySupport = true
)
public final class ServiceCategory implements Model {

  public static final ServiceCategoryPath rootPath = new ServiceCategoryPath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("ServiceCategory", "id");
  public static final QueryField NAME = field("ServiceCategory", "name");
  public static final QueryField PARENT_CATEGORY_ID = field(
    "ServiceCategory",
    "parentCategoryId"
  );
  public static final QueryField PARENT_CATEGORY = field(
    "ServiceCategory",
    "parentCategoryId"
  );
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String name;
  private final @ModelField(targetType = "ID") String parentCategoryId;
  private final @ModelField(targetType = "ServiceCategory") @BelongsTo(
    targetName = "parentCategoryId",
    type = ServiceCategory.class
  ) ModelReference<ServiceCategory> parentCategory;
  private final @ModelField(targetType = "ServiceCategory") @HasMany(
    associatedWith = "parentCategory",
    type = ServiceCategory.class
  ) ModelList<ServiceCategory> childCategories = null;
  private final @ModelField(targetType = "Service") @HasMany(
    associatedWith = "category",
    type = Service.class
  ) ModelList<Service> services = null;
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

  public String getParentCategoryId() {
    return parentCategoryId;
  }

  public ModelReference<ServiceCategory> getParentCategory() {
    return parentCategory;
  }

  public ModelList<ServiceCategory> getChildCategories() {
    return childCategories;
  }

  public ModelList<Service> getServices() {
    return services;
  }

  public Temporal.DateTime getCreatedAt() {
    return createdAt;
  }

  public Temporal.DateTime getUpdatedAt() {
    return updatedAt;
  }

  private ServiceCategory(
    String id,
    String name,
    String parentCategoryId,
    ModelReference<ServiceCategory> parentCategory
  ) {
    this.id = id;
    this.name = name;
    this.parentCategoryId = parentCategoryId;
    this.parentCategory = parentCategory;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      ServiceCategory serviceCategory = (ServiceCategory) obj;
      return (
        ObjectsCompat.equals(getId(), serviceCategory.getId()) &&
        ObjectsCompat.equals(getName(), serviceCategory.getName()) &&
        ObjectsCompat.equals(
          getParentCategoryId(),
          serviceCategory.getParentCategoryId()
        ) &&
        ObjectsCompat.equals(
          getParentCategory(),
          serviceCategory.getParentCategory()
        ) &&
        ObjectsCompat.equals(getCreatedAt(), serviceCategory.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), serviceCategory.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getParentCategoryId())
      .append(getParentCategory())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("ServiceCategory {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append(
        "parentCategoryId=" + String.valueOf(getParentCategoryId()) + ", "
      )
      .append("parentCategory=" + String.valueOf(getParentCategory()) + ", ")
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
  public static ServiceCategory justId(String id) {
    return new ServiceCategory(id, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id, name, parentCategoryId, parentCategory);
  }

  public interface NameStep {
    BuildStep name(String name);
  }

  public interface BuildStep {
    ServiceCategory build();
    BuildStep id(String id);
    BuildStep parentCategoryId(String parentCategoryId);
    BuildStep parentCategory(ServiceCategory parentCategory);
  }

  public static class Builder implements NameStep, BuildStep {

    private String id;
    private String name;
    private String parentCategoryId;
    private ModelReference<ServiceCategory> parentCategory;

    public Builder() {}

    private Builder(
      String id,
      String name,
      String parentCategoryId,
      ModelReference<ServiceCategory> parentCategory
    ) {
      this.id = id;
      this.name = name;
      this.parentCategoryId = parentCategoryId;
      this.parentCategory = parentCategory;
    }

    @Override
    public ServiceCategory build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new ServiceCategory(id, name, parentCategoryId, parentCategory);
    }

    @Override
    public BuildStep name(String name) {
      Objects.requireNonNull(name);
      this.name = name;
      return this;
    }

    @Override
    public BuildStep parentCategoryId(String parentCategoryId) {
      this.parentCategoryId = parentCategoryId;
      return this;
    }

    @Override
    public BuildStep parentCategory(ServiceCategory parentCategory) {
      this.parentCategory = new LoadedModelReferenceImpl<>(parentCategory);
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
      String parentCategoryId,
      ModelReference<ServiceCategory> parentCategory
    ) {
      super(id, name, parentCategoryId, parentCategory);
      Objects.requireNonNull(name);
    }

    @Override
    public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }

    @Override
    public CopyOfBuilder parentCategoryId(String parentCategoryId) {
      return (CopyOfBuilder) super.parentCategoryId(parentCategoryId);
    }

    @Override
    public CopyOfBuilder parentCategory(ServiceCategory parentCategory) {
      return (CopyOfBuilder) super.parentCategory(parentCategory);
    }
  }
}
