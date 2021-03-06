package yuan.sim.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import yuan.sim.constants.ApiAnnotationConstants;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

import static yuan.sim.constants.DefaultPackageName.ENCODING;

/**
 * 基础配置
 * @QQ交流群: 648741281
 * @Email: 177300883312@163.com
 * @微信: londu19930418
 * @Author: Simon.Mr
 * @Created 2020/9/29
 */
@Data
@Builder
@AllArgsConstructor
public class AutoDocConfig {

    /**
     * 资源目录
     */
    private String sourcePath;

    /**
     * 当前需要处理的目录位置
     */
    private String currentPath;

    /**
     * 文档生成目录
     */
    private String outPath;

    /**
     * 编码格式 默认UTF-8
     */
    private Charset encoding;

    /**
     * 扫码类上面的注解 默认处理Controller RestController
     */
    private List<String> scanAnnotationNames;

    public AutoDocConfig() {

        this.encoding = Charset.forName(ENCODING);
        this.scanAnnotationNames = Arrays.asList(ApiAnnotationConstants.CONTROLLER_NAME,ApiAnnotationConstants.REST_CONTROLLER_NAME);

    }
}


