package com.cyx.java_web.web_04_file;

import com.cyx.java_web.exception.ImageUploadException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class FileUtil {

    private static final String ALLOWABLE_IMAGE_TYPE = "png;jpg;bmp";

    public static void upload(HttpServletRequest req) {
        // 检擦是否有文件上传请求。
        // （查看源码发现：其实是判断是否为 POST 请求以及请求体类型是否以“multipart/”开头）。
        if (ServletFileUpload.isMultipartContent(req)) {
            // 创建文件项工厂（DiskFileItemFactory 对象）。
            // DiskFileItemFactory：设置磁盘空间，保存临时文件。只是一个具类。
            // 声明 DiskFileItemFactory 工厂类，用于在指的磁盘上设置一个临时目录。
            DiskFileItemFactory factory = new DiskFileItemFactory();
            // 设置缓存大小（单位：字节）
            factory.setSizeThreshold(20 * 1024);
            // 配置存储库(以确保使用安全的临时位置)
            // 从 ServletContext 中获取应用服务器的临时目录。
            ServletContext servletContext = req.getServletContext();
            File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
            // 设置用于存储临时文件的临时目录。
            factory.setRepository(repository);
            // 创建文件上传处理器。
            ServletFileUpload upload = new ServletFileUpload(factory);

            try {
                // 1、设置单个上传文件的最大允许大小（单位：字节）
                upload.setFileSizeMax(100 * 1024);
                // 2、设置该次请求的最大大小（单位：字节）
                upload.setSizeMax(2 * 100 * 1024);

                /*
                    FileItem 类的常用方法：
                        boolean isFormField()：
                            isFormField 方法用来判断 FileItem 对象里面封装的数据是一个普通文本表单字段，还是一个文件表单字段。
                            如果是普通文本表单字段，返回一个 true 否则返回一个 false。
                            因此可以用该方法判断是否是普通表单域还是文件上传表单域。

                        String getFieldName()：
                            getFieldName 方法用来返回表单标签的 name 属性的值。

                        String getString()：
                            getString 方法将 FileItem 对象中保存的数据流内容以一个字符串返回。
                            它有两个重载形式：
                                public java.lang.String getString() 和
                                public java.lang.String getString(java.lang.String encoding) throws java.io.UnsupportedEncodingException。
                            前者使用缺省的字符集编码将主体内容转换成字符串，后者使用参数指定的字符集编码。
                            如果在读取普通表单字段元素的内容时，出现了乱码现象，可以调用第二个方法，并传入 正确的字符集编码名称。

                        String getName()：
                            getName 方法用来获得文件上传字段中的文件名。

                        void write(File file)：
                            write 方法将 FileItem 对象中的内容保存到某个指定的文件中。
                            如果 FileItem 对象中的内容是保存在某个临时文件中，该方法完成后，临时文件可能会被删除。
                            该方法也可以将普通表单字段保存在一个文件中，但最主要的用途是把上传的文件内容保存在本地文件系统中。

                        String getContentType()：
                            此方法用来获得上传文件的类型，即标段字段元素描述头属性“content-type”的值，如 image/jpeg。
                            如果 FileItem 对象对应的是普通的表单字段，将返回 null。

                        boolean isInMemory()：
                            判断 FileItem 对象封装的数据是保存在内存中还是硬盘中。

                        void delete()：
                            此方法用来清空 FileItem 对象中封装的主体内容，如果内容是被保存在临时文件中，该方法会把临时文件删除。

                        InputStream getInputStream()：
                            以流的形式返回上传文件的主体内容。

                        long getSize()：
                            返回上传文件的大小（单位：字节）。
                */

                // 解析请求（获取请求参数集合：FileItem 对象）
                List<FileItem> items = upload.parseRequest(req);
                // 迭代出每一个 FileItem 对象
                for (FileItem item : items) {
                    // 获取表单空间的 name 属性的值（参数名）
                    String name = item.getFieldName();
                    if (item.isFormField()) {
                        // 因为会有中文，这里设置编码为 UTF-8（因为表单类型为二进制类型，没有进行编码，
                        // 所以使用 req.setCharacterEncoding("UTF-8"); 是无效的）
                        String value = item.getString("UTF-8");
                        System.out.println(name + "：" + value);
                    } else {
                        // 获取文件名拓展名
                        String extension = FilenameUtils.getExtension(item.getName());
                        // 判断文件是否是允许的类型，如果是不允许类型，则跳回原页面，并带上错误信息
                        if (!Arrays.asList(ALLOWABLE_IMAGE_TYPE.split(";")).contains(extension)) {
                            throw new ImageUploadException("请上传 " + ALLOWABLE_IMAGE_TYPE + " 类型的图片");
                        }
                        System.out.println(name + "：" + item.getName());
                        // 将内容写入指定目录的文件中，并为文件设置一个唯一的文件名，防止文件名重复导致文件覆盖
                        item.write(new File("F:/", UUID.randomUUID() + "." + extension));
                    }
                }
            } catch (FileUploadBase.FileSizeLimitExceededException e) {
                // 捕获异常并向上抛出
                throw new ImageUploadException("上传图片大小不能超过 100 KB");
            } catch (FileUploadBase.SizeLimitExceededException e) {
                throw new ImageUploadException("该次请求大小不能超过 200 KB");
            } catch (ImageUploadException e) {
                // 因为下面捕捉异常后会直接做打印处理，而没有向上抛出，所以我们在之前捕捉我们自定义的异常，然后向上抛出错误信息
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
