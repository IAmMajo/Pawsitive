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

/** This is an auto generated class representing the Clinic type in your schema. */
@SuppressWarnings("all")
@ModelConfig(
  pluralName = "Clinics",
  authRules = {
    @AuthRule(
      allow = AuthStrategy.PUBLIC,
      provider = "iam",
      operations = { ModelOperation.READ }
    ),
  },
  hasLazySupport = true
)
public final class Clinic implements Model {

  public static final ClinicPath rootPath = new ClinicPath("root", false, null);
  public static final QueryField ID = field("Clinic", "id");
  public static final QueryField NAME = field("Clinic", "name");
  public static final QueryField IMAGE_PATH = field("Clinic", "imagePath");
  public static final QueryField STREET = field("Clinic", "street");
  public static final QueryField HOUSE_NUMBER = field("Clinic", "houseNumber");
  public static final QueryField ADDRESS_DETAILS = field(
    "Clinic",
    "addressDetails"
  );
  public static final QueryField POSTAL_CODE = field("Clinic", "postalCode");
  public static final QueryField PLACE = field("Clinic", "place");
  public static final QueryField LONGITUDE = field("Clinic", "longitude");
  public static final QueryField LATITUDE = field("Clinic", "latitude");
  public static final QueryField OPENING_HOURS = field(
    "Clinic",
    "openingHours"
  );
  public static final QueryField PHONE = field("Clinic", "phone");
  public static final QueryField EMAIL = field("Clinic", "email");
  public static final QueryField WEBSITE = field("Clinic", "website");
  private final @ModelField(targetType = "ID", isRequired = true) String id;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String name;
  private final @ModelField(targetType = "String") String imagePath;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String street;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String houseNumber;
  private final @ModelField(targetType = "String") String addressDetails;
  private final @ModelField(
    targetType = "Int",
    isRequired = true
  ) Integer postalCode;
  private final @ModelField(
    targetType = "String",
    isRequired = true
  ) String place;
  private final @ModelField(
    targetType = "Float",
    isRequired = true
  ) Double longitude;
  private final @ModelField(
    targetType = "Float",
    isRequired = true
  ) Double latitude;
  private final @ModelField(targetType = "String") String openingHours;
  private final @ModelField(targetType = "AWSPhone") String phone;
  private final @ModelField(targetType = "AWSEmail") String email;
  private final @ModelField(targetType = "AWSURL") String website;
  private final @ModelField(targetType = "Vet") @HasMany(
    associatedWith = "clinic",
    type = Vet.class
  ) ModelList<Vet> vets = null;
  private final @ModelField(targetType = "ClinicRating") @HasMany(
    associatedWith = "clinic",
    type = ClinicRating.class
  ) ModelList<ClinicRating> ratings = null;
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

  public String getStreet() {
    return street;
  }

  public String getHouseNumber() {
    return houseNumber;
  }

  public String getAddressDetails() {
    return addressDetails;
  }

  public Integer getPostalCode() {
    return postalCode;
  }

  public String getPlace() {
    return place;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Double getLatitude() {
    return latitude;
  }

  public String getOpeningHours() {
    return openingHours;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  public String getWebsite() {
    return website;
  }

  public ModelList<Vet> getVets() {
    return vets;
  }

  public ModelList<ClinicRating> getRatings() {
    return ratings;
  }

  public Temporal.DateTime getCreatedAt() {
    return createdAt;
  }

  public Temporal.DateTime getUpdatedAt() {
    return updatedAt;
  }

  private Clinic(
    String id,
    String name,
    String imagePath,
    String street,
    String houseNumber,
    String addressDetails,
    Integer postalCode,
    String place,
    Double longitude,
    Double latitude,
    String openingHours,
    String phone,
    String email,
    String website
  ) {
    this.id = id;
    this.name = name;
    this.imagePath = imagePath;
    this.street = street;
    this.houseNumber = houseNumber;
    this.addressDetails = addressDetails;
    this.postalCode = postalCode;
    this.place = place;
    this.longitude = longitude;
    this.latitude = latitude;
    this.openingHours = openingHours;
    this.phone = phone;
    this.email = email;
    this.website = website;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj == null || getClass() != obj.getClass()) {
      return false;
    } else {
      Clinic clinic = (Clinic) obj;
      return (
        ObjectsCompat.equals(getId(), clinic.getId()) &&
        ObjectsCompat.equals(getName(), clinic.getName()) &&
        ObjectsCompat.equals(getImagePath(), clinic.getImagePath()) &&
        ObjectsCompat.equals(getStreet(), clinic.getStreet()) &&
        ObjectsCompat.equals(getHouseNumber(), clinic.getHouseNumber()) &&
        ObjectsCompat.equals(getAddressDetails(), clinic.getAddressDetails()) &&
        ObjectsCompat.equals(getPostalCode(), clinic.getPostalCode()) &&
        ObjectsCompat.equals(getPlace(), clinic.getPlace()) &&
        ObjectsCompat.equals(getLongitude(), clinic.getLongitude()) &&
        ObjectsCompat.equals(getLatitude(), clinic.getLatitude()) &&
        ObjectsCompat.equals(getOpeningHours(), clinic.getOpeningHours()) &&
        ObjectsCompat.equals(getPhone(), clinic.getPhone()) &&
        ObjectsCompat.equals(getEmail(), clinic.getEmail()) &&
        ObjectsCompat.equals(getWebsite(), clinic.getWebsite()) &&
        ObjectsCompat.equals(getCreatedAt(), clinic.getCreatedAt()) &&
        ObjectsCompat.equals(getUpdatedAt(), clinic.getUpdatedAt())
      );
    }
  }

  @Override
  public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getImagePath())
      .append(getStreet())
      .append(getHouseNumber())
      .append(getAddressDetails())
      .append(getPostalCode())
      .append(getPlace())
      .append(getLongitude())
      .append(getLatitude())
      .append(getOpeningHours())
      .append(getPhone())
      .append(getEmail())
      .append(getWebsite())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }

  @Override
  public String toString() {
    return new StringBuilder()
      .append("Clinic {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("imagePath=" + String.valueOf(getImagePath()) + ", ")
      .append("street=" + String.valueOf(getStreet()) + ", ")
      .append("houseNumber=" + String.valueOf(getHouseNumber()) + ", ")
      .append("addressDetails=" + String.valueOf(getAddressDetails()) + ", ")
      .append("postalCode=" + String.valueOf(getPostalCode()) + ", ")
      .append("place=" + String.valueOf(getPlace()) + ", ")
      .append("longitude=" + String.valueOf(getLongitude()) + ", ")
      .append("latitude=" + String.valueOf(getLatitude()) + ", ")
      .append("openingHours=" + String.valueOf(getOpeningHours()) + ", ")
      .append("phone=" + String.valueOf(getPhone()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("website=" + String.valueOf(getWebsite()) + ", ")
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
  public static Clinic justId(String id) {
    return new Clinic(
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
      null,
      null,
      null,
      null
    );
  }

  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(
      id,
      name,
      imagePath,
      street,
      houseNumber,
      addressDetails,
      postalCode,
      place,
      longitude,
      latitude,
      openingHours,
      phone,
      email,
      website
    );
  }

  public interface NameStep {
    StreetStep name(String name);
  }

  public interface StreetStep {
    HouseNumberStep street(String street);
  }

  public interface HouseNumberStep {
    PostalCodeStep houseNumber(String houseNumber);
  }

  public interface PostalCodeStep {
    PlaceStep postalCode(Integer postalCode);
  }

  public interface PlaceStep {
    LongitudeStep place(String place);
  }

  public interface LongitudeStep {
    LatitudeStep longitude(Double longitude);
  }

  public interface LatitudeStep {
    BuildStep latitude(Double latitude);
  }

  public interface BuildStep {
    Clinic build();
    BuildStep id(String id);
    BuildStep imagePath(String imagePath);
    BuildStep addressDetails(String addressDetails);
    BuildStep openingHours(String openingHours);
    BuildStep phone(String phone);
    BuildStep email(String email);
    BuildStep website(String website);
  }

  public static class Builder
    implements
      NameStep,
      StreetStep,
      HouseNumberStep,
      PostalCodeStep,
      PlaceStep,
      LongitudeStep,
      LatitudeStep,
      BuildStep {

    private String id;
    private String name;
    private String street;
    private String houseNumber;
    private Integer postalCode;
    private String place;
    private Double longitude;
    private Double latitude;
    private String imagePath;
    private String addressDetails;
    private String openingHours;
    private String phone;
    private String email;
    private String website;

    public Builder() {}

    private Builder(
      String id,
      String name,
      String imagePath,
      String street,
      String houseNumber,
      String addressDetails,
      Integer postalCode,
      String place,
      Double longitude,
      Double latitude,
      String openingHours,
      String phone,
      String email,
      String website
    ) {
      this.id = id;
      this.name = name;
      this.imagePath = imagePath;
      this.street = street;
      this.houseNumber = houseNumber;
      this.addressDetails = addressDetails;
      this.postalCode = postalCode;
      this.place = place;
      this.longitude = longitude;
      this.latitude = latitude;
      this.openingHours = openingHours;
      this.phone = phone;
      this.email = email;
      this.website = website;
    }

    @Override
    public Clinic build() {
      String id = this.id != null ? this.id : UUID.randomUUID().toString();

      return new Clinic(
        id,
        name,
        imagePath,
        street,
        houseNumber,
        addressDetails,
        postalCode,
        place,
        longitude,
        latitude,
        openingHours,
        phone,
        email,
        website
      );
    }

    @Override
    public StreetStep name(String name) {
      Objects.requireNonNull(name);
      this.name = name;
      return this;
    }

    @Override
    public HouseNumberStep street(String street) {
      Objects.requireNonNull(street);
      this.street = street;
      return this;
    }

    @Override
    public PostalCodeStep houseNumber(String houseNumber) {
      Objects.requireNonNull(houseNumber);
      this.houseNumber = houseNumber;
      return this;
    }

    @Override
    public PlaceStep postalCode(Integer postalCode) {
      Objects.requireNonNull(postalCode);
      this.postalCode = postalCode;
      return this;
    }

    @Override
    public LongitudeStep place(String place) {
      Objects.requireNonNull(place);
      this.place = place;
      return this;
    }

    @Override
    public LatitudeStep longitude(Double longitude) {
      Objects.requireNonNull(longitude);
      this.longitude = longitude;
      return this;
    }

    @Override
    public BuildStep latitude(Double latitude) {
      Objects.requireNonNull(latitude);
      this.latitude = latitude;
      return this;
    }

    @Override
    public BuildStep imagePath(String imagePath) {
      this.imagePath = imagePath;
      return this;
    }

    @Override
    public BuildStep addressDetails(String addressDetails) {
      this.addressDetails = addressDetails;
      return this;
    }

    @Override
    public BuildStep openingHours(String openingHours) {
      this.openingHours = openingHours;
      return this;
    }

    @Override
    public BuildStep phone(String phone) {
      this.phone = phone;
      return this;
    }

    @Override
    public BuildStep email(String email) {
      this.email = email;
      return this;
    }

    @Override
    public BuildStep website(String website) {
      this.website = website;
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
      String street,
      String houseNumber,
      String addressDetails,
      Integer postalCode,
      String place,
      Double longitude,
      Double latitude,
      String openingHours,
      String phone,
      String email,
      String website
    ) {
      super(
        id,
        name,
        imagePath,
        street,
        houseNumber,
        addressDetails,
        postalCode,
        place,
        longitude,
        latitude,
        openingHours,
        phone,
        email,
        website
      );
      Objects.requireNonNull(name);
      Objects.requireNonNull(street);
      Objects.requireNonNull(houseNumber);
      Objects.requireNonNull(postalCode);
      Objects.requireNonNull(place);
      Objects.requireNonNull(longitude);
      Objects.requireNonNull(latitude);
    }

    @Override
    public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }

    @Override
    public CopyOfBuilder street(String street) {
      return (CopyOfBuilder) super.street(street);
    }

    @Override
    public CopyOfBuilder houseNumber(String houseNumber) {
      return (CopyOfBuilder) super.houseNumber(houseNumber);
    }

    @Override
    public CopyOfBuilder postalCode(Integer postalCode) {
      return (CopyOfBuilder) super.postalCode(postalCode);
    }

    @Override
    public CopyOfBuilder place(String place) {
      return (CopyOfBuilder) super.place(place);
    }

    @Override
    public CopyOfBuilder longitude(Double longitude) {
      return (CopyOfBuilder) super.longitude(longitude);
    }

    @Override
    public CopyOfBuilder latitude(Double latitude) {
      return (CopyOfBuilder) super.latitude(latitude);
    }

    @Override
    public CopyOfBuilder imagePath(String imagePath) {
      return (CopyOfBuilder) super.imagePath(imagePath);
    }

    @Override
    public CopyOfBuilder addressDetails(String addressDetails) {
      return (CopyOfBuilder) super.addressDetails(addressDetails);
    }

    @Override
    public CopyOfBuilder openingHours(String openingHours) {
      return (CopyOfBuilder) super.openingHours(openingHours);
    }

    @Override
    public CopyOfBuilder phone(String phone) {
      return (CopyOfBuilder) super.phone(phone);
    }

    @Override
    public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }

    @Override
    public CopyOfBuilder website(String website) {
      return (CopyOfBuilder) super.website(website);
    }
  }
}
