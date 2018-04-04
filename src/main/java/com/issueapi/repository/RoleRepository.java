package com.issueapi.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.issueapi.model.Role;

@Repository
public interface RoleRepository {
	@Select("select * from tblrole")
	public List<Role> findAll();
	
	@Select("select * from tblrole where roleID=#{id}")
	public Role findRoleById(Integer id);
	
	@Insert("INSERT INTO `tblrole`(`roleID`, `roleName`,`createBy`, `updateBy`, `createDate`, `updateDate`) "
			+ "VALUES (#{roleID},#{roleName},#{createBy}, #{updateBy}, #{createDate}, #{updateDate})")
	public boolean save(Role role);

	@Delete("DELETE FROM `tblrole` WHERE `roleID`= #{id}")
	public boolean removeRoleById(Integer id);
	
	@Update("UPDATE `tblrole` SET `roleID`=#{roleID},`roleName`=#{roleName},"
			+ "`createBy`=#{createBy},`updateBy`=#{updateBy},`createDate`=#{createDate},"
			+ "`updateDate`=#{updateDate} WHERE `roleID`= #{roleID}")
	public boolean updateRoleById(Role role);
}

