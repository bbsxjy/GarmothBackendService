package com.gbs.core.config;

public final class RoutingConfig {
    // Prevent instantiation
    private RoutingConfig() {
    }

    // Middleware routing information
    public static final String MIDDLEWARE_API_V1 = "/api/v1";

    public static final String MIDDLEWARE_IMAGES_GENERATION_PATH = "/imagesGeneration";

    public static final String MIDDLEWARE_OBJECT_DETECTION_PATH  = "/objectDetection";

    // Stable diffusion routing information
    public static final String STABLE_DIFFUSION_SERVER_URL = "http://localhost:7861";

    public static final String STABLE_DIFFUSION_SERVER_2_URL = "http://localhost:6631";

    public static final String STABLE_DIFFUSION_API_V1 = "/sdapi/v1";

    // Yolo routing information
    public static final String YOLO_SERVER_URL = "http://localhost:5465";

    public static final String YOLO_API_V1 = "/odapi/v1";
}
