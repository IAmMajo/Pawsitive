package com.amplifyframework.datastore.generated.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.amplifyframework.core.model.ModelPath;
import com.amplifyframework.core.model.PropertyPath;

/** This is an auto generated class representing the ModelPath for the ServiceCategory type in your schema. */
public final class ServiceCategoryPath extends ModelPath<ServiceCategory> {

  private ServiceCategoryPath parentCategory;
  private ServiceCategoryPath childCategories;
  private ServicePath services;

  ServiceCategoryPath(
    @NonNull String name,
    @NonNull Boolean isCollection,
    @Nullable PropertyPath parent
  ) {
    super(name, isCollection, parent, ServiceCategory.class);
  }

  public synchronized ServiceCategoryPath getParentCategory() {
    if (parentCategory == null) {
      parentCategory = new ServiceCategoryPath("parentCategory", false, this);
    }
    return parentCategory;
  }

  public synchronized ServiceCategoryPath getChildCategories() {
    if (childCategories == null) {
      childCategories = new ServiceCategoryPath("childCategories", true, this);
    }
    return childCategories;
  }

  public synchronized ServicePath getServices() {
    if (services == null) {
      services = new ServicePath("services", true, this);
    }
    return services;
  }
}
