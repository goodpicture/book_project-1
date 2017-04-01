package kr.or.dgit.book_project.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.book_project.dto.PublisherInfo;

public class PublisherInfoMapperImpl implements PublisherInfoMapper {
	private String namespace="kr.or.dgit.book_project.dao.PublisherInfoMapper.";
	private static final Log log = LogFactory.getLog(BookInfoMapper.class);
	private SqlSession sqlSession;	
	
	public PublisherInfoMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int insertPubliherShort(PublisherInfo publisherInfo) {
		log.debug("insertPubliherShort()");
		return sqlSession.insert(namespace + "insertPubliherShort", publisherInfo);
	}
	@Override
	public int selectCountAll() {
		log.debug("selectCountAll()");
		return sqlSession.selectOne(namespace + "selectCountAll");
	}
	@Override
	public List<PublisherInfo> selectByAll() {
		log.debug("selectByAll()");
		return sqlSession.selectList(namespace + "selectByAll");
	}
}
