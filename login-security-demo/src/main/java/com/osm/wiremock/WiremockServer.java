/**
 * 
 */
package com.osm.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.configureFor;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.removeAllMappings;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

/**
 * @author ouShiMing
 *
 */
public class WiremockServer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		configureFor(8062);  //监听wiremock服务的端口号Wiremock已经被添加到配置里面，所以不用写了
		removeAllMappings(); //每次启动都把上一次的配置清空

		wiremockInfo("/order/1", "01");
		wiremockInfo("/order/2", "02");
		
	}

	public static void wiremockInfo(String url, String file) throws IOException {
		ClassPathResource resource = new ClassPathResource("resources/response/" + file + ".txt");
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray());
		stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)));
		
		/*urlPathEqualTo("/order/1"): 写一个严格的，标准的URL*/
//		stubFor(get(urlPathEqualTo("/order/1")).willReturn(aResponse().withBody("{\"id\":1}").withStatus(200)));
		/*urlPathMatching(urlRegex): 里面写一个正则表达式，匹配URL*/
	}
}
