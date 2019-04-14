/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.antmeite.api.demo.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.antmeite.code.base.ResponseBase;

/**
 * 会员服务接口
 */
public interface IDemoMemberService {

	@GetMapping("/demoMember")
	public ResponseBase demoMember(@RequestParam("userId") Long userId);

}
