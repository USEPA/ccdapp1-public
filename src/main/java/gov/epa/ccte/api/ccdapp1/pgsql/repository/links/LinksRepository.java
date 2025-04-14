package gov.epa.ccte.api.ccdapp1.pgsql.repository.links;



import gov.epa.ccte.api.ccdapp1.pgsql.domain.links.LinkDisplay;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.links.Links;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import io.swagger.v3.oas.annotations.Hidden;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "links", path = "links")
public interface LinksRepository extends JpaRepository<Links, Integer> {


    @RestResource(exported = false)
    @Query("select new gov.epa.ccte.api.ccdapp1.pgsql.domain.links.LinkDisplay(cl.iconUrl, cl.label, cl.name, cl.url, cl.description, " +
            "cl.noResultsResponse, cl.paramType,i.paramValue,i.dtxsid) from Links  as cl left join Ids " +
            "as i on cl.paramType =i.paramType and i.dtxsid =:id order by cl.label, cl.name")
    List<LinkDisplay> findLinksByDtxsid(@Param("id") String dtxsid);

    @Override
    @Hidden
    @RestResource(exported = false)
    <S extends Links> S save(S s);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteById(Integer integer);

    @Override
    @Hidden
    @RestResource(exported = false)
    void delete(Links links);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Links> iterable);

    @Override
    @Hidden
    @RestResource(exported = false)
    void deleteAll();
}





