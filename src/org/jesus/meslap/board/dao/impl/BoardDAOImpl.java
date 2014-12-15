package org.jesus.meslap.board.dao.impl;

import java.util.Date;
import java.util.List;



















import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument.Restriction;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.jesus.meslap.board.dao.BoardDAO;
import org.jesus.meslap.entity.Board;
import org.jesus.meslap.entity.BoardAdmin;
import org.jesus.meslap.entity.BoardFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession(){
		Session session = sessionFactory.getCurrentSession();
		if(session == null)
			session = sessionFactory.openSession();
		return session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Board> getBoardList(String boardCode, Integer fRow, Integer pageSize){
		Criteria crit = getSession().createCriteria(Board.class);
		crit.add(Restrictions.eq("boardCode", boardCode))
			.addOrder(Order.desc("id"))
			.setFirstResult(fRow)
			.setMaxResults(pageSize);
		
		return crit.list();
	}
	
	public void saveBoard(Board board) {
		getSession().saveOrUpdate(board);
		//return (Integer) getSession().saveOrUpdate(board);
	}

	public Board getBoard(Integer boardId) {
		Query query = getSession().createQuery("from Board b where b.id = :boardId");
		query.setParameter("boardId", boardId);
		Board result = (Board) query.uniqueResult();
		return result;
	}
	
	public void deleteBoard(Integer boardId){
		Board board = getBoard(boardId);
		getSession().delete(board);
		//Query query = getSession().createQuery("delete from Board b where b.id = :boardId");
		//query.setParameter("boardId", boardId);
		//query.executeUpdate();
	}

	public void saveBoardFile(BoardFile boardFile) {
		getSession().saveOrUpdate(boardFile);
	}

	public List<BoardAdmin> getBoardAdminList() {
		Criteria crit = getSession().createCriteria(BoardAdmin.class);
		return crit.list();
	}

	public boolean getCheckBoardAdmin(BoardAdmin boardAdmin) {
		Query query = getSession().createQuery("select count(*) from BoardAdmin ba where ba.boardCode = :boardCode");
		query.setParameter("boardCode", boardAdmin.getBoardCode());
		Long count = (Long)query.uniqueResult();
		if(count.intValue()>0){
			return true;
		}
		return false;
	}

	public void createBoard(BoardAdmin boardAdmin) {
		boardAdmin.setWdate(new Date());
		getSession().saveOrUpdate(boardAdmin);
	}
	
	public BoardAdmin getBoardAdmin(String boardCode){
		return (BoardAdmin) getSession().get(BoardAdmin.class, boardCode);
		//Criteria crit = getSession().createCriteria(BoardAdmin.class);
	}

	public Integer getBoardCount(String boardCode) {
		Criteria crit = getSession().createCriteria(Board.class);
		crit.add(Restrictions.eq("boardCode", boardCode));
		crit.setProjection(Projections.rowCount());
		Long count = (Long) crit.uniqueResult();
		return count.intValue();
	}

	public List<String> getCategorys() {
		Criteria crit = getSession().createCriteria(Board.class);
		crit.setProjection(Projections.distinct(Projections.property("category")));
		return crit.list();
	}
}
