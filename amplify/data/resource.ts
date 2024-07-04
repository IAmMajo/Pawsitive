import { type ClientSchema, a, defineData } from "@aws-amplify/backend";

/*
 * Entity Relationship Diagram for the database schema:
 * https://dl.maxoverlack.dev/Pawsitive-Datenbank.svg
 */
const schema = a.schema({
  Vet: a
    .model({
      name: a.string().required(),
      imagePath: a.string(),
      specialization: a.string(),
      clinicId: a.id().required(),
      clinic: a.belongsTo("Clinic", "clinicId"),
      ratings: a.hasMany("VetRating", "vetId"),
    })
    .authorization((allow) => [allow.guest().to(["read"])]),
  Clinic: a
    .model({
      name: a.string().required(),
      imagePath: a.string(),
      street: a.string().required(),
      houseNumber: a.string().required(),
      addressDetails: a.string(),
      postalCode: a.integer().required(),
      place: a.string().required(),
      latitude: a.float().required(),
      longitude: a.float().required(),
      openingHours: a.string(),
      phone: a.phone(),
      email: a.email(),
      website: a.url(),
      vets: a.hasMany("Vet", "clinicId"),
      ratings: a.hasMany("ClinicRating", "clinicId"),
    })
    .authorization((allow) => [allow.guest().to(["read"])]),
  VetRating: a
    .model({
      vetId: a.id().required(),
      ratingDiagnosis: a.integer().required(),
      ratingTreatment: a.integer().required(),
      ratingInformation: a.integer().required(),
      ratingTrust: a.integer(),
      ratingInvestedTime: a.integer(),
      ratingFriendliness: a.integer(),
      comment: a.string(),
      vet: a.belongsTo("Vet", "vetId"),
      services: a.hasMany("VetRatingService", "ratingId"),
      pets: a.hasMany("VetRatingPet", "ratingId"),
      owner: a
        .string()
        .required()
        .authorization((allow) => [
          allow.guest().to(["read"]),
          allow.owner().to(["read", "delete"]),
        ]),
    })
    .authorization((allow) => [allow.guest().to(["read"]), allow.owner()]),
  ClinicRating: a
    .model({
      clinicId: a.id().required(),
      ratingWaitingTime: a.integer(),
      ratingEquipment: a.integer(),
      ratingPhoneAvailability: a.integer(),
      ratingParking: a.integer(),
      ratingPricePerformance: a.integer(),
      ratingAlternativeMedicine: a.integer(),
      comment: a.string(),
      clinic: a.belongsTo("Clinic", "clinicId"),
      pets: a.hasMany("ClinicRatingPet", "ratingId"),
      owner: a
        .string()
        .required()
        .authorization((allow) => [
          allow.guest().to(["read"]),
          allow.owner().to(["read", "delete"]),
        ]),
    })
    .authorization((allow) => [allow.guest().to(["read"]), allow.owner()]),
  VetRatingService: a
    .model({
      ratingId: a.id().required(),
      serviceNumber: a.id().required(),
      rating: a.belongsTo("VetRating", "ratingId"),
      service: a.belongsTo("Service", "serviceNumber"),
      owner: a
        .string()
        .required()
        .authorization((allow) => [
          allow.guest().to(["read"]),
          allow.owner().to(["read", "delete"]),
        ]),
    })
    .authorization((allow) => [allow.guest().to(["read"]), allow.owner()]),
  VetRatingPet: a
    .model({
      ratingId: a.id().required(),
      petId: a.id().required(),
      rating: a.belongsTo("VetRating", "ratingId"),
      pet: a.belongsTo("Pet", "petId"),
      owner: a
        .string()
        .required()
        .authorization((allow) => [
          allow.guest().to(["read"]),
          allow.owner().to(["read", "delete"]),
        ]),
    })
    .authorization((allow) => [allow.guest().to(["read"]), allow.owner()]),
  ClinicRatingPet: a
    .model({
      ratingId: a.id().required(),
      petId: a.id().required(),
      rating: a.belongsTo("ClinicRating", "ratingId"),
      pet: a.belongsTo("Pet", "petId"),
      owner: a
        .string()
        .required()
        .authorization((allow) => [
          allow.guest().to(["read"]),
          allow.owner().to(["read", "delete"]),
        ]),
    })
    .authorization((allow) => [allow.guest().to(["read"]), allow.owner()]),
  Service: a
    .model({
      id: a.string().required(),
      name: a.string().required(),
      categoryId: a.id().required(),
      category: a.belongsTo("ServiceCategory", "categoryId"),
      ratings: a.hasMany("VetRatingService", "serviceNumber"),
    })
    .authorization((allow) => [allow.guest().to(["read"])]),
  Pet: a
    .model({
      name: a.string().required(),
      imagePath: a.string(),
      species: a.string(),
      breed: a.string(),
      birthDate: a.date(),
      vetRatings: a.hasMany("VetRatingPet", "petId"),
      clinicRatings: a.hasMany("ClinicRatingPet", "petId"),
      owner: a
        .string()
        .required()
        .authorization((allow) => [
          allow.guest().to(["read"]),
          allow.owner().to(["read", "delete"]),
        ]),
    })
    .authorization((allow) => [allow.guest().to(["read"]), allow.owner()]),
  ServiceCategory: a
    .model({
      name: a.string().required(),
      parentCategoryId: a.id(),
      parentCategory: a.belongsTo("ServiceCategory", "parentCategoryId"),
      childCategories: a.hasMany("ServiceCategory", "parentCategoryId"),
      services: a.hasMany("Service", "categoryId"),
    })
    .authorization((allow) => [allow.guest().to(["read"])]),
});

export type Schema = ClientSchema<typeof schema>;

export const data = defineData({
  schema,
  authorizationModes: {
    defaultAuthorizationMode: "iam",
  },
});
