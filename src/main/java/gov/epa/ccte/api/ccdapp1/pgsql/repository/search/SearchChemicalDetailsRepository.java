package gov.epa.ccte.api.ccdapp1.pgsql.repository.search;

import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ChemicalLongResult;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.ChemicalShortResult;
import gov.epa.ccte.api.ccdapp1.pgsql.domain.search.SearchChemicalDetails;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface SearchChemicalDetailsRepository  extends JpaRepository<SearchChemicalDetails, String> {

// -- start with
    // -- short
    @Query(nativeQuery = true)
    List<ChemicalShortResult> startWithShortWithoutInchi(@Param("searchWord") String searchWord);

    @Query(nativeQuery = true)
    List<ChemicalShortResult> startWithShort(@Param("searchWord") String searchWord);

    @Query(nativeQuery = true)
    List<ChemicalShortResult> startWithShortWithList(@Param("searchWord") String searchWord, @Param("list") String listName);

    // -- long
    @Query(nativeQuery = true)
    List<ChemicalLongResult> startWithLongWithoutInchi(@Param("searchWord") String searchWord);

    @Query(nativeQuery = true)
    List<ChemicalLongResult> startWithLong(@Param("searchWord") String searchWord);

    // -- count
    @Query(value="select count(distinct c.dtxsid) from {h-schema}search_chemical c where c.modified_value like  :word% ", nativeQuery = true)
    Optional<Long> startWithCount(@Param("word") String searchWord);

    @RestResource(exported = false)
    @Query(value =  " select count(distinct c.dtxsid) from {h-schema}search_chemical c join ccd_app.chemlist_to_subtance cts " +
            " on c.dtxsid = cts.dtxsid and cts.list_name = :list " +
            " where c.modified_value like  :word% ",
            nativeQuery = true)
    Optional<Long> startWithCountWithListName(@Param("word") String searchWord, @Param("list") String listName);

//    @RestResource(exported = false)
//    <T> List<T> findTop20BySearchMatchInAndModifiedValueStartsWithOrderByRankAscSearchWordAsc(List<String> searchMatchToInclude, String searchWord, Class<T> type);
//
//    @RestResource(exported = false)
//    <T> List<T> findByModifiedValueStartsWithOrderByRankAscSearchMatchAsc(String searchWord, Class<T> type);


// -- contain search

    @Query(nativeQuery = true)
    List<ChemicalShortResult> containShort(@Param("searchWord") String searchWord);

    @Query(nativeQuery = true)
    List<ChemicalLongResult> containLong(@Param("searchWord") String searchWord);

    @RestResource(exported = false)
    @Query(value = "select count(distinct c.dtxsid) from {h-schema}search_chemical c where c.modified_value like %:searchWord% ", nativeQuery = true)
    Optional<Long> countContain(@Param("searchWord") String searchWord);

    @RestResource(exported = false)
    @Query("select distinct c.dtxsid from SearchChemical c where c.modifiedValue like %:word% order by c.dtxsid ")
    List<String> containSearchForDtxsid(@Param("word") String searchWord);

    @RestResource(exported = false)
/*    @Query(value =  " select distinct cts.dtxsid from ccd_app.search_chemical c join ccd_app.chemlist_to_subtance cts " +
            " on c.dtxsid = cts.dtxsid and cts.list_name = :list " +
            " where c.modified_value like  %:word% order by s.rank asc",
            nativeQuery = true)*/
//    @Query(value = "select distinct s.dtxsid from SearchChemicalDetails s join ChemicalListToSubstance c " +
//            " on s.dtxsid = c.dtxsid and c.listName = :list and s.modifiedValue like %:word% order by s.dtxsid ")
    @Query(value = "select distinct c.dtxsid from {h-schema}search_chemical c join ccd_app.chemlist_to_subtance l on l.dtxsid = c.dtxsid " +
            "and l.list_name = :list and c.modified_value like %:word% ", nativeQuery = true)
    List<String> containSearchForDtxsidWithListName(@Param("word") String searchWord, @Param("list") String listName);

// -- equal search

    @Query(nativeQuery = true)
    List<ChemicalShortResult> equalShort(@Param("searchWord") String searchWord);

    @Query(nativeQuery = true)
    List<ChemicalLongResult> equalLong(@Param("searchWord") String searchWord);

    // structure
    @Query(nativeQuery = true)
    List<ChemicalShortResult> equalStructureShort(@Param("structure") String structure);

    @Query(nativeQuery = true)
    List<ChemicalLongResult> equalStructureLong(@Param("structure") String structure);

    @RestResource(path = "by-dtxsid", rel = "find-by-dtxsid")
    SearchChemicalDetails findByDtxsidEquals(@Param("id") String dtxsid);

    @Query(value = "select d.pubchem_cid from {h-schema}chemical_details d where d.dtxsid = :dtxsid ", nativeQuery = true)
    Integer getPubchemCid(@Param("dtxsid") String dtxsid);
}
