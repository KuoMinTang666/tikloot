package io.github.kuomintang666.Tikloot.IO;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ResourceLoader {
    Class<?> targetclass;
    List<ResourceType> avaliableresourcetypes;
    String resourcesubdirectory;

    /**
     * directory name and extension of resource types:
     * 
     * RESOURCETYPE_SOUND:Sound .mp3
     * 
     * RESOURCETYPE_VIDEO:Video .mp4
     * 
     * RESOURCETYPE_SOUND:Image .png
     * 
     * RESOURCETYPE_SOUND:XML .xml
     * 
     * RESOURCETYPE_SOUND:Other (no extension, add extension by your self pls)
     * 
     * cause by something(just classloader can't find directory by getResouece)
     * 
     * create the file .ex in the resource directory,pls
     * 
     * .e.g:
     * 
     * resource/image/.ex
     * 
     */
    public static class ResourceType {
        private String resourcedirectoryname, extensionname;
        public static final ResourceType RESOURCETYPE_SOUND = new ResourceType("Sound", "mp3"),
                RESOURCETYPE_VIDEO = new ResourceType("Video", "mp4"),
                RESOURCETYPE_IMAGE = new ResourceType("Image", "png"),
                RESOURCETYPE_XML = new ResourceType("XML", "xml"),
                RESOURCETYPE_OTHER = new ResourceType("Other", "");

        public ResourceType(String directoryname, String extension) {
            resourcedirectoryname = directoryname;
            extensionname = extension;
        }

        public String getdirectoryName() {
            return resourcedirectoryname;
        }

        public String getExtensionName() {
            return extensionname;
        }
    }

    /**
     * 
     * @param trg           the target class in the resource directory
     * @param resourcetypes the types of resources need to use
     * @param subdirectory  the directory name of resource directory, if this
     *                      parameter is
     *                      empty or null, it will be setted to "resource"
     */
    public ResourceLoader(Class<?> trg, String subdirectory, ResourceType... resourcetypes) throws IOException {
        targetclass = trg;

        if (subdirectory == null || subdirectory.isEmpty()) {
            resourcesubdirectory = "resource";
        } else {
            resourcesubdirectory = subdirectory;
        }
        avaliableresourcetypes = Arrays.asList(resourcetypes);
        for (ResourceType i : resourcetypes) {
            if (trg.getResource(i.getdirectoryName() + "/.ex") == null)
                throw new IOException("Resource not found " + i.getdirectoryName() + """
                        1.
                        please check is the directory exist
                        2.
                        please check is the file ".ex" in your resource directory
                                                """);
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
            return targetclass.getResource(resourcesubdirectory + "/" + type.getdirectoryName() + '/' + name);
        } else {
            return targetclass.getResource(
                    resourcesubdirectory + "/" + type.getdirectoryName() + '/' + name + "." + type.extensionname);
        }

    }

    public Class<?> getTargetclass() {
        return targetclass;
    }
}
