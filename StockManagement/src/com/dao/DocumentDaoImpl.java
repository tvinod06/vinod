package com.dao;

import java.util.Date;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import com.constant.Constants;
import com.session.HibernateSession;
import com.valueobject.Document;

@Transactional
public class DocumentDaoImpl extends HibernateSession implements DocumentDao{

	@Override
	public Long saveDocumentDtl(Document doc)
			throws Exception {
		if(doc.getAccessType() == null){
			doc.setAccessType(Constants.LOOKUP_PUBLIC);
		}
		if(doc.getDocumentMstId() == null || doc.getDocumentMstId() == 0L){
			doc.setDocumentMstId(System.currentTimeMillis());
			doc.setCreatedDate(new Date());
			doc.setCreatedBy(1L);
			getSession().saveOrUpdate(doc);
		} else {
			Query query = getSession().createQuery(
					"update Document set " + "  accessType= :accessType"
							+ " ,purpose= :purpose "
							+ ", category = :category "
							+ " ,fileType = :fileType "
							+ " ,fileName= :fileName"
							+ " ,fileBytes=:fileBytes "
							+ " , updatedDate = :date "
							+ " , updatedBy= :updatedBy "
							+ " where documentMstId = :documentMstId");
			query.setParameter("accessType", doc.getAccessType());
			query.setParameter("purpose", doc.getPurpose());
			query.setParameter("category", doc.getCategory());
			query.setParameter("fileName", doc.getFileName());
			query.setParameter("date", new Date());
			query.setParameter("updatedBy", -1L);
			query.setParameter("fileType", doc.getFileType());
			query.setParameter("fileBytes", doc.getFileBytes());
			query.setParameter("documentMstId", doc.getDocumentMstId());
			query.executeUpdate();
		}
		getSession().getTransaction().commit();
		return doc.getDocumentMstId();
	}
	
}