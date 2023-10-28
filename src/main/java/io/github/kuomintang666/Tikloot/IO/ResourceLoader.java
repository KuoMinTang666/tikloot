package io.github.kuomintang666.Tikloot.IO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResourceLoader {
    Class<?> targetclass;
    List<ResourceType> avaliableresourcetypes;
    String resourcesubfolder;

    /**
     * folder name and extension of resource types:
     * RESOURCETYPE_SOUND:Sound .mp3
     * RESOURCETYPE_VIDEO:Video .mp4
     * RESOURCETYPE_SOUND:Image .png
     * RESOURCETYPE_SOUND:XML .xml
     * RESOURCETYPE_SOUND:Other (no extension, add extension by your self pls)
     * 
     */
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
     * @param subfolder     the folder name of resource folder, if this parameter is
     *                      empty or null, it will be setted to "resource"
     */
    public ResourceLoader(Class<?> trg, String subfolder, ResourceType... resourcetypes) throws IOException {
        targetclass = trg;

        if (subfolder == null || subfolder.isEmpty()) {
            resourcesubfolder = "resource";
        } else {
            resourcesubfolder = subfolder;
        }
        avaliableresourcetypes = Arrays.asList(resourcetypes);
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
        if (type.getExtensionName().isEmpty() & avaliableresourcetypes.contains(type)) {
            return targetclass.getResource(resourcesubfolder + "/" + type.getFolderName() + '/' + name);
        } else {
            return targetclass.getResource(
                    resourcesubfolder + "/" + type.getFolderName() + '/' + name + "." + type.extensionname);
        }

    }

    public Class<?> getTargetclass() {
        return targetclass;
    }
}
