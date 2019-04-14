/**
 * 功能说明:
 * 功能作者:
 * 创建日期:
 * 版权归属:每特教育|蚂蚁课堂所有 www.itmayiedu.com
 */
package com.antmeite.api.order;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.antmeite.code.base.ResponseBase;
import com.itmayeidu.api.entity.OrderEntity;

/**
 *  订单服务接口
 *
 */
public interface IOrderService {

	/**
	 * 用户下单后调用库存服务进行扣库存
	 * 
	 * @return
	 */
	@GetMapping(value = "/addOrderAndStock")
	public ResponseBase addOrderAndStock(int i) throws Exception;

}
