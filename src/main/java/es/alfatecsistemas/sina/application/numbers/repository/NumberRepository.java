package es.alfatecsistemas.sina.application.numbers.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: vicboma1
 */
@Repository
public class NumberRepository {

  private Set<Integer> set;

  public NumberRepository() {
    set = new HashSet<>();
  }

  //POST
  public Boolean add(final Integer a){
    return this.set.add(a);
  }

  //POST
  public Boolean addAll(final Collection collec){
    return this.set.addAll(collec);
  }

  //DELETE
  public Boolean delete(final Integer a){
    return this.set.remove(a);
  }

  //GET
  public Integer size(){
    return this.set.size();
  }

  //GET
  public Boolean clear() {
    try {
      this.set.clear();
      return true;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
  }
}
