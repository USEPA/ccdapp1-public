package gov.epa.ccte.api.ccdapp1.pgsql.repository;


import gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.TabDisplayDetail;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.Tabs;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "tabs", path = "tabs")
public interface TabsRepository extends PagingAndSortingRepository<Tabs, Integer>, CrudRepository<Tabs, Integer> {

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid", exported = false)
    @Query("SELECT new gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.TabDisplayDetail(t.label ,t.labelDisplay ,t.category ,t.subCategory,t.url,cds.disable, t.listName, cds.dtxsid )FROM Tabs t  JOIN ChemicalDataStatus  cds on t.label = cds.label where t.visible = true and t.listName = 'STANDARD' and cds.dtxsid=:id order by t.displayOrder")
    List<TabDisplayDetail> findTabsBydtxsid(@Param("id") String dtxsid);


    @RestResource(path = "by-dtxcid", rel = "find-by-dtxcid", exported = false)
    @Query("SELECT new gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.TabDisplayDetail(t.label ,t.labelDisplay ,t.category ,t.subCategory,t.url,cds.disable, t.listName, cds.dtxcid )FROM Tabs t  JOIN ChemicalDataStatus  cds on t.label = cds.label where t.visible = true and t.listName = 'STANDARD' and cds.dtxcid=:id order by t.displayOrder")
    List<TabDisplayDetail> findTabsBydtxcid(@Param("id") String dtxcid);

    @RestResource(path = "by-dtxsid-list", rel = "find-by-dtxsid-and-list", exported = false)
    @Query("SELECT new gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.TabDisplayDetail(t.label ,t.labelDisplay ,t.category ,t.subCategory,t.url,cds.disable, cds.dtxsid , t.listName)FROM Tabs t  JOIN ChemicalDataStatus  cds on t.label = cds.label where t.visible = true and t.listName=:list  and cds.dtxsid=:id order by t.displayOrder")
    List<TabDisplayDetail> findTabsBydtxsidAndListName(@Param("id") String dtxsid, @Param("list") String listName);


    @RestResource(path = "by-dtxcid-list", rel = "find-by-dtxcid-and-list", exported = false)
    @Query("SELECT new gov.epa.ccte.api.ccdapp1.pgsql.domain.tabs.TabDisplayDetail(t.label ,t.labelDisplay ,t.category ,t.subCategory,t.url,cds.disable, cds.dtxsid, t.listName )FROM Tabs t  JOIN ChemicalDataStatus  cds on t.label = cds.label where t.visible = true and t.listName=:list  and cds.dtxcid=:id order by t.displayOrder")
    List<TabDisplayDetail> findTabsBydtxcidAndListName(@Param("id") String dtxsid, @Param("list") String listName);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Tabs> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Tabs> Iterable<S> saveAll(Iterable<S> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Tabs tabs);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Tabs> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}
