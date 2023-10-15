package net.kuomintang666.Tikloot.IO;

import java.io.IOException;
import java.net.URL;

public class ResourceLoader {
    Class<?> targetclass;
    ResourceType[] avaliableresourcetypes;

    public static class ResourceType {
        private String resourcefoldername, extensionname;
        public static final ResourceType RESOURCETYPE_SOUND = new ResourceType("Sound", "mp3"),
                RESOURCETYPE_VIDEO = new ResourceType("Video", "mp4"),
                RESOURCETYPE_IMAGE = new ResourceType("Image", "png"),
                RESOURCETYPE_XML = new ResourceType("XML", "xml"),
                RESOURCETYPE_OTHER = new ResourceType("Other", "");

        public ResourceType(String foldername, String extension) {
            resourcefoldername = foldername;
            extensionname = extension;
        }

        public String getFolderName() {
            return resourcefoldername;
        }

        public String getExtensionName() {
            return extensionname;
        }
    }

    /**
     * 
     * @param trg           the target class in the resource folder
     * @param resourcetypes the types of resources need to use
     */
    public ResourceLoader(Class<?> trg, ResourceType... resourcetypes) throws IOException {
        targetclass = trg;
        avaliableresourcetypes = resourcetypes;
        for (ResourceType i : resourcetypes) {
            if (trg.getResource(i.getFolderName()) == null)
                throw new IOException("Resource not found " + i.getFolderName());
        }
    }

    /**
     * load resource by the target class
     * 
     * @param type resource type (resource location)
     * @param name resource name
     * @return
     */
    public URL loadResource(ResourceType type, String name) {
        return targetclass.getResource(type.getFolderName() + '/' + name + '.' + type.getExtensionName());
    }

    public Class<?> getTargetclass() {
        return targetclass;
    }
}
