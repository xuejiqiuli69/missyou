/**
 * @作者 leokkzhang
 * @创建时间 2020/5/5 21:39
 */
package com.lin.missyou.api.v1;

import com.lin.missyou.bo.PageCounter;
import com.lin.missyou.core.LocalUser;
import com.lin.missyou.core.interceptors.ScopeLevel;
import com.lin.missyou.dto.OrderDTO;
import com.lin.missyou.exception.http.NotFoundException;
import com.lin.missyou.logic.OrderChecker;
import com.lin.missyou.model.Order;
import com.lin.missyou.service.OrderService;
import com.lin.missyou.util.CommonUtil;
import com.lin.missyou.vo.OrderIdVO;
import com.lin.missyou.vo.OrderPureVO;
import com.lin.missyou.vo.OrderSimplifyVO;
import com.lin.missyou.vo.PagingDozer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Value("${missyou.order.pay-time-limit}")
    private Long payTimeLimit;

    @PostMapping("")
    @ScopeLevel
    public OrderIdVO placeOrder(@RequestBody OrderDTO orderDTO) {
        Long uid = LocalUser.getUser().getId();
        //校验订单
        OrderChecker orderChecker = orderService.isOk(uid, orderDTO);
        //下单
        Long oid = orderService.placeOrder(uid,orderDTO,orderChecker);
        return new OrderIdVO(oid);
    }


    @ScopeLevel
    @GetMapping("/status/unpaid")
    public PagingDozer<Order,OrderSimplifyVO> getUnpaid(@RequestParam(defaultValue = "0")
                                                Integer start,
                                             @RequestParam(defaultValue = "10")
                                                Integer count){
        PageCounter page = CommonUtil.convertToPageParameter(start, count);
        Page<Order> orderPage = orderService.getUnpaid(page.getPage(),page.getCount());
        PagingDozer pagingDozer = new PagingDozer<>(orderPage, OrderSimplifyVO.class);
        pagingDozer.getItems()
                .forEach(o->((OrderSimplifyVO)o).setPeriod(payTimeLimit));
        return pagingDozer;
    }


    @ScopeLevel
    @GetMapping("/by/status/{status}")
    public PagingDozer<Order, OrderSimplifyVO> getByStatus(@PathVariable int status,  //补全对status的校验
                                                           @RequestParam(defaultValue = "0")
                                                                   Integer start,
                                                           @RequestParam(defaultValue = "10")
                                                                   Integer count) {
        PageCounter page = CommonUtil.convertToPageParameter(start, count);
        Page<Order> orderPage = orderService.getByStatus(status, page.getPage(), page.getCount());
        PagingDozer pagingDozer = new PagingDozer<>(orderPage, OrderSimplifyVO.class);
        pagingDozer.getItems()
                .forEach(o -> ((OrderSimplifyVO) o).setPeriod(payTimeLimit));
        return pagingDozer;
    }

    @ScopeLevel
    @GetMapping("/detail/{id}")
    public OrderPureVO getOrderDetail(@PathVariable(name = "id") Long oid) {
        Optional<Order> orderOptional = orderService.getOrderDetail(oid);
        return orderOptional.map(o -> new OrderPureVO(o, payTimeLimit))
                .orElseThrow(() -> new NotFoundException(50009));
    }
}
