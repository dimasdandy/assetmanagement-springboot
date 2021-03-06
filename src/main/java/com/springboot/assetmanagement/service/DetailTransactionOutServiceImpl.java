package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.DetailTransactionOutDao;
import com.springboot.assetmanagement.dao.TransactionOutDao;
import com.springboot.assetmanagement.dto.DetailTransactionOutDto;
import com.springboot.assetmanagement.dto.PostDetailTransactionOutDto;
import com.springboot.assetmanagement.model.Asset;
import com.springboot.assetmanagement.model.DetailTransactionOut;
import com.springboot.assetmanagement.model.TransactionOut;

@Service
public class DetailTransactionOutServiceImpl implements DetailTransactionOutService {

	@Autowired
	private DetailTransactionOutDao detailTrxOutDao;
	
	@Autowired
	private TransactionOutDao trxOutDao;

	@Override
	public List<DetailTransactionOutDto> getByTrxOutId(String trxOutId) throws Exception {
		return detailTrxOutDao.getByTrxOutId(trxOutId);
	}

	@Override
	@Transactional
	public void addTransactionOutDetail(PostDetailTransactionOutDto detailTransactionOutDto) throws Exception {
		DetailTransactionOut detailTrxOut = new DetailTransactionOut();
		
		TransactionOut trxOut = trxOutDao.getIdByEntity(detailTransactionOutDto.getParentTrxId());
		trxOut.setId(detailTransactionOutDto.getParentTrxId());
		detailTrxOut.setTransactionOut(trxOut);
		
		Asset asset = new Asset();
		asset.setId(detailTransactionOutDto.getAssetId());
		detailTrxOut.setAsset(asset);
		
		detailTrxOut.setDueDate(detailTransactionOutDto.getDueDate());
		detailTrxOut.setCreatedBy("admin");
		detailTrxOut.setCreatedDate(LocalDateTime.now());
		detailTrxOut.setVersion(0L);
		detailTrxOut.setIsActive(true);
		
		detailTrxOutDao.addTransactionOutDetail(detailTrxOut);
	}

//	@Autowired
//	private RolesService rolesService;
	
//	@Override
//	@Transactional
//	public Long insert(InsertUserReqDto data) throws Exception {
//		Users users = new Users();
//		Roles roles = rolesService.getById(data.getRole());
//		users.setName(data.getName());
//		users.setUsername(data.getUsername());
//		users.setPassword(bCryptPasswordEncoder.encode(data.getPassword()));
//		users.setRole(roles);
//		users.setCreatedBy(super.users());
//		users.setIsActive(data.getIsActive());
//		usersDao.insert(users);
//		return users.getId();
//	}
//
//	@Override
//	@Transactional
//	public void update(UpdateUserReqDto data) throws Exception {
//		userValidation.updateValidation(data);
//		
//		Users users = getById(data.getId());
//		Roles roles = rolesService.getById(data.getRole());
//
//		users.setName(data.getName());
//		users.setUsername(data.getUsername());
//		users.setRole(roles);
//		users.setUpdatedBy(super.users());
//		users.setIsActive(data.getIsActive());
//		users.setVersion(data.getVersion());
//		usersDao.update(users);
//
//		Users usersUpdate = usersDao.getById(data.getId());
//		data.setVersion(usersUpdate.getVersion());
//	}
//
//	@Override
//	@Transactional
//	public void delete(Long id) throws Exception {
//		DeleteUserReqDto delete = new DeleteUserReqDto();
//		delete.setId(id);
//		userValidation.deleteValidation(delete);
//		usersDao.delete(id);
//	}
//
//	@Override
//	public List<FindAllPathUsersResData> getAll() throws Exception {
//		List<FindAllPathUsersResData> findAll = new ArrayList<FindAllPathUsersResData>();
//
//		List<Users> users = usersDao.getAll();
//		for (Users user : users) {
//			FindAllPathUsersResData allPath = new FindAllPathUsersResData();
//			allPath.setId(user.getId());
//			allPath.setName(user.getName());
//			allPath.setUsername(user.getUsername());
//			allPath.setRoleId(user.getRole().getId());
//			allPath.setRoleCode(user.getRole().getCode());
//			allPath.setRoleName(user.getRole().getName());
//			findAll.add(allPath);
//		}
//		return findAll;
//	}

}
