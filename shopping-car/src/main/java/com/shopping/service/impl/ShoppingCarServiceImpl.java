package com.shopping.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.base.constant.DBConst;
import com.project.base.constant.DateConstant;
import com.project.base.filter.SessionFilter;
import com.project.base.util.DateUtil;
import com.shopping.dao.GoodsDao;
import com.shopping.dao.OrderDao;
import com.shopping.dao.ShoppingCarDao;
import com.shopping.entity.Goods;
import com.shopping.entity.Order;
import com.shopping.entity.ShoppingCar;
import com.shopping.po.UserShoppingCar;
import com.shopping.service.GoodsService;
import com.shopping.service.ShoppingCarService;

@Service
public class ShoppingCarServiceImpl implements ShoppingCarService{
	@Autowired
	private ShoppingCarDao shoppingCarDao;
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsDao goodsDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void addCar(Integer goodsId) {
		Goods goods = goodsService.getGoods(goodsId);
		Integer userId = SessionFilter.getUserId();
		ShoppingCar car = shoppingCarDao.getByGoodsAndUser(goodsId,userId);
		if(car != null) {
			car.addCount(1);
			shoppingCarDao.update(car);
		} else {
			car = new ShoppingCar();
			car.setUserId(userId);
			car.setGoodsId(goodsId);
			shoppingCarDao.save(car);
		}
		goods.subLeft(1);
		goodsDao.update(goods);
	}

	@Override
	public UserShoppingCar myCars() {
		Integer userId = SessionFilter.getUserId();
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT t1.id,t1.goods_id AS goodsId,");
		sql.append(" t2.NAME AS NAME,");
		sql.append(" t1.nums AS nums,");
		sql.append(" t1.nums * t2.price AS totalPrices,");
		sql.append(" t2.image AS image");
		sql.append(" FROM "+DBConst.SHOPPING_CAR+" t1");
		sql.append(" LEFT JOIN "+DBConst.GOODS+" t2 ON t1.goods_id = t2.id");
		sql.append(" WHERE t1.user_id = ?");
		List<ShoppingCar> list = shoppingCarDao.queryShoppingCars(sql.toString(),Arrays.asList(userId));
		UserShoppingCar userShoppingCar = new UserShoppingCar();
		userShoppingCar.setUserId(userId);
		userShoppingCar.setList(list);
		return userShoppingCar;
	}
	
	@Override
	public void purchase(Integer id) {
		Long orderNo = System.nanoTime();
		String date = DateUtil.dateConvertStr(new Date(), DateConstant.WHOLE_TIME);
		if(id != null) {
			ShoppingCar shoppingCar = shoppingCarDao.get(ShoppingCar.class, id);
			removeCarItem(id, null, shoppingCar,false);
			createOrder(orderNo, shoppingCar,date);
		} else {
			Integer userId = SessionFilter.getUserId();
			String hql = "from " + ShoppingCar.class.getSimpleName() + " where userId = ?";
			List<ShoppingCar> list = shoppingCarDao.queryList(hql, Arrays.asList(userId));
			for(ShoppingCar car : list) {
				removeCarItem(car.getId(),null, car,false);
				createOrder(orderNo, car,date);
			}
		}
	}

	private void createOrder(Long orderNo, ShoppingCar shoppingCar,String fdate) {
		Goods goods = goodsDao.get(Goods.class, shoppingCar.getGoodsId());
		Integer userId = SessionFilter.getUserId();
		Order order = new Order();
		order.setGoodsName(goods.getName());
		order.setNums(shoppingCar.getNums());
		order.setPrice(goods.getPrice());
		order.setNums(shoppingCar.getNums());
		order.setOrderNo(orderNo);
		order.setUserId(userId);
		order.setFdate(fdate);
		order.setTotalPrice(order.getNums() * order.getPrice());
		orderDao.save(order);
	}
	
	@Override
	public void delete(Integer id, Integer count) {
		if(id != null) {
			ShoppingCar shoppingCar = shoppingCarDao.get(ShoppingCar.class, id);
			removeCarItem(id, count, shoppingCar,true);
		} else {
			Integer userId = SessionFilter.getUserId();
			String hql = "from " + ShoppingCar.class.getSimpleName() + " where userId = ?";
			List<ShoppingCar> list = shoppingCarDao.queryList(hql, Arrays.asList(userId));
			for(ShoppingCar car : list) {
				removeCarItem(car.getId(),null, car,true);
			}
		}
	}

	private void removeCarItem(Integer id, Integer count, ShoppingCar shoppingCar,boolean isCancel) {
		Goods goods = goodsService.getGoods(shoppingCar.getGoodsId());
		Integer addCount = count;
		if(count == null) {
			shoppingCarDao.deleteById(ShoppingCar.class, id);
			addCount = shoppingCar.getNums();
		} else {
			shoppingCar.subCount(count);
			if(shoppingCar.getNums() <= 0) {
				shoppingCarDao.deleteById(ShoppingCar.class, id);
				addCount = shoppingCar.getNums();
			} else {
				shoppingCarDao.update(shoppingCar);
			}
		}
		if(isCancel) {
			goods.addLeft(addCount);
			this.goodsDao.update(goods);
		}
	}
}
