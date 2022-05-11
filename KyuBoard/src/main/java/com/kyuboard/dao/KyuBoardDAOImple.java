package com.kyuboard.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kyuboard.domain.KyuBoardVO;


@Repository
public class KyuBoardDAOImple implements KyuBoardDAO {

		
		@Inject
		private SqlSession sql;
		
		private static String namespace = "com.KyuBoard.mappers.board";
		
		//게시물 목록
		@Override
		public List<KyuBoardVO> list() throws Exception {
			
			
			return sql.selectList(namespace + ".list");
		}
		
		//게시물 작성
		@Override
		public void write(KyuBoardVO vo) throws Exception {
			
			sql.insert(namespace + ".write", vo);
			
		}

		//게시물 조회
		@Override
		public KyuBoardVO view(int bno) throws Exception {

			return sql.selectOne(namespace + ".view", bno);
		}

		//게시물 수정
		@Override
		public void modify(KyuBoardVO vo) throws Exception {

			sql.update(namespace + ".modify", vo);
		}

		//게시물 삭제
		@Override
		public void delete(int bno) throws Exception {	//게시물 번호만 있으면 삭제 가능하기 때문에 매개변수를 int bno로 설정
			
			sql.delete(namespace + ".delete", bno);
		}

		//게시물 총 갯수
		@Override
		public int count() throws Exception {

			return sql.selectOne(namespace + ".count");
		}

		//게시물 목록 + 페이징
		@Override
		public List<KyuBoardVO> listPage(int displayPost, int postNum) throws Exception {
			
			HashMap data = new HashMap();
			
			data.put("displayPost", displayPost);
			data.put("postNum", postNum);
			
			return sql.selectList(namespace + ".listPage", data);
		}

		// 게시물 목록 + 페이징 + 검색
		 @Override
		 public List<KyuBoardVO> listPageSearch(
		   int displayPost, int postNum, String searchType, String keyword) throws Exception {

		  HashMap<String, Object> data = new HashMap<String, Object>();
		  
		  data.put("displayPost", displayPost);
		  data.put("postNum", postNum);
		  
		  data.put("searchType", searchType);
		  data.put("keyword", keyword);
		  
		  return sql.selectList(namespace + ".listPageSearch", data);
		 }

		//게시물 총 갯수 + 검색 적용
		@Override
		public int searchCount(String searchType, String keyword) throws Exception {
			
			  HashMap data = new HashMap();
			  
			  data.put("searchType", searchType);
			  data.put("keyword", keyword);
			  
			  return sql.selectOne(namespace + ".searchCount", data);
			
		}
		
	
	

}

