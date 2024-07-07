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

/** This is an auto generated class representing the Favorite type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "Favorites",
  authRules = {
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
public final class Favorite implements Model {

  public static final FavoritePath rootPath = new FavoritePath(
    "root",
    false,
    null
  );
  public static final QueryField ID = field("Favorite", "id");
  public static final QueryField VET_ID = field("Favorite", "vetId");
  public static final QueryField VET = field("Favorite", "vetId");
  public static final QueryField OWNER = field("Favorite", "owner");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(targetType = "ID", isRequired = true) String vetId;
  private final @ModelField(targetType = "Vet") @BelongsTo(
    targetName = "vetId",
    type = Vet.class
  ) ModelReference<Vet> vet;
  private final @ModelField(
    targetType = "String",
    isRequired = true,
    authRules = {
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

  public ModelReference<Vet> getVet() {
    return vet;
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

  private Favorite(
    String id,
    String vetId,
    ModelReference<Vet> vet,
    String owner
  ) {
    this.id = id;
    this.vetId = vetId;
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
      Favorite favorite = (Favorite) obj;
      return (
        ObjectsCompat.equals(getId(), favorite.getId()) &&
        ObjectsCompat.equals(getVetId(), favorite.getVetId()) &&
        ObjectsCompat.equals(getVet(), favorite.getVet()) &&
        ObjectsCompat.equals(getOwner(), favorite.getOwner()) &&
        ObjectsCompat.equals(getCreatedAt(), favorite.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), favorite.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getVetId())
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
      .append("Favorite {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("vetId=" + String.valueOf(getVetId()) + ", ")
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
  public static Favorite justId(String id) {
    return new Favorite(id, null, null, null);
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id, vetId, vet, owner);
  }

  public interface VetIdStep {
    OwnerStep vetId(String vetId);
  }

  public interface OwnerStep {
    BuildStep owner(String owner);
  }

  public interface BuildStep {
    Favorite build();
    BuildStep id(String id);
    BuildStep vet(Vet vet);
  }

  public static class Builder implements VetIdStep, OwnerStep, BuildStep {

    private String id;
    private String vetId;
    private String owner;
    private ModelReference<Vet> vet;

    public Builder() {}

    private Builder(
      String id,
      String vetId,
      ModelReference<Vet> vet,
      String owner
    ) {
      this.id = id;
      this.vetId = vetId;
      this.vet = vet;
      this.owner = owner;
    }

    @Override
    public Favorite build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new Favorite(id, vetId, vet, owner);
    }

    @Override
    public OwnerStep vetId(String vetId) {
      Objects.requireNonNull(vetId);
      this.vetId = vetId;
      return this;
    }

    @Override
    public BuildStep owner(String owner) {
      Objects.requireNonNull(owner);
      this.owner = owner;
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
      ModelReference<Vet> vet,
      String owner
    ) {
      super(id, vetId, vet, owner);
      Objects.requireNonNull(vetId);
      Objects.requireNonNull(owner);
    }

    @Override
    public CopyOfBuilder vetId(String vetId) {
      return (CopyOfBuilder) super.vetId(vetId);
    }

    @Override
    public CopyOfBuilder owner(String owner) {
      return (CopyOfBuilder) super.owner(owner);
    }

    @Override
    public CopyOfBuilder vet(Vet vet) {
      return (CopyOfBuilder) super.vet(vet);
    }
  }
}
