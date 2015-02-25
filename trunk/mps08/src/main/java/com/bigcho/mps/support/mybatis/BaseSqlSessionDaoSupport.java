package com.bigcho.mps.support.mybatis;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * SqlSessionDaoSupport를 상속받아 sqlSessionTemplate를 부모 클래스에 set한다.
 * @author 조호영
 * @since 2014.12.26
 * @version 0.1
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *  수정일                   수정자         수정내용
 *  ----------  ----    ---------------------------
 *  2014.12.26  조호영          최초 작성
 *
 * </pre>
 */

public abstract class BaseSqlSessionDaoSupport extends SqlSessionDaoSupport {
	
	@Resource(name = "sqlSession")
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
}
