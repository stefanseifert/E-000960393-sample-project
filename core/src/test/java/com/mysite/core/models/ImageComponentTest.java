package com.mysite.core.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.sling.models.factory.ModelFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.day.cq.wcm.api.Page;
import com.mysite.core.testcontext.AppAemContext;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;

@ExtendWith(AemContextExtension.class)
class ImageComponentTest {

  private final AemContext context = AppAemContext.newAemContext();

  private ModelFactory modelFactory;
  private Page page;

  @BeforeEach
  public void setup() throws Exception {
    modelFactory = context.getService(ModelFactory.class);
    page = context.create().page("/content/mypage");
  }

  @Test
  void testImageComponentV1() throws Exception {
    context.currentResource(context.create().resource(page, "image-v1",
        "sling:resourceType", "core/wcm/components/image/v1/image"));
    assertNotNull(modelFactory.getModelFromRequest(context.request()));
  }

  @Test
  void testImageComponentV2() throws Exception {
    context.currentResource(context.create().resource(page, "image-v2",
        "sling:resourceType", "core/wcm/components/image/v2/image"));
    assertNotNull(modelFactory.getModelFromRequest(context.request()));
  }

  @Test
  void testImageComponentV3() throws Exception {
    context.currentResource(context.create().resource(page, "image-v3",
        "sling:resourceType", "core/wcm/components/image/v3/image"));
    assertNotNull(modelFactory.getModelFromRequest(context.request()));
  }

}
