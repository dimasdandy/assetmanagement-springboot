package com.springboot.assetmanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.assetmanagement.dao.DetailTransactionInDao;
import com.springboot.assetmanagement.dao.TransactionInDao;
import com.springboot.assetmanagement.dto.DetailTransactionInDto;
import com.springboot.assetmanagement.dto.PostDetailTransactionInDto;
import com.springboot.assetmanagement.model.Asset;
import com.springboot.assetmanagement.model.AssetCondition;
import com.springboot.assetmanagement.model.DetailTransactionIn;
import com.springboot.assetmanagement.model.TransactionIn;
import com.springboot.login.service.BaseServiceImpl;

@Service
public class DetailTransactionInServiceImpl extends BaseServiceImpl implements DetailTransactionInService {

	@Autowired
	private DetailTransactionInDao detailTrxInDao;

	@Autowired
	private TransactionInDao trxInDao;

	@Autowired
	private TransactionInService trxInService;

	@Override
	public List<DetailTransactionInDto> getByTrxInId(String trxInId) throws Exception {
		return detailTrxInDao.getByTrxInId(trxInId);
	}

	@Override
	@Transactional
	public void addTransactionInDetail(PostDetailTransactionInDto detailTransactionInDto) throws Exception {
		DetailTransactionIn detailTrxIn = new DetailTransactionIn();

		TransactionIn trxIn = trxInDao.getIdByEntity(detailTransactionInDto.getParentTrxId());
		trxIn.setId(detailTransactionInDto.getParentTrxId());
		detailTrxIn.setTransactionIn(trxIn);

		Asset asset = new Asset();
		asset.setId(detailTransactionInDto.getAssetId());
		detailTrxIn.setAsset(asset);
		
		AssetCondition assetCondition = new AssetCondition();
		assetCondition.setId(detailTransactionInDto.getAssetConditionId());
		detailTrxIn.setAssetCondition(assetCondition);

		detailTrxIn.setCreatedBy("admin");
		detailTrxIn.setCreatedDate(LocalDateTime.now());
		detailTrxIn.setVersion(0L);
		detailTrxIn.setIsActive(true);

		detailTrxInDao.addTransactionInDetail(detailTrxIn);
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
