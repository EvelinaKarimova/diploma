package ru.itis.diplom.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.diplom.models.Block;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
    @Override
    List<Block> findAll();
}
