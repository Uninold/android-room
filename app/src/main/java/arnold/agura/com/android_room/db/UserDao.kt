package arnold.agura.com.android_room.db

import android.arch.persistence.room.*

/**
 * Created by Arnold on 28 Apr 2018.
 */

@Dao
interface UserDao {
    @Query("select * from user")
    fun loadAllUsers(): List<User>

    @Query("select * from user where id = :id")
    fun loadUserById(id: Int): User

    @Query("select * from user where name = :firstName and lastName = :lastName")
    fun findUserByNameAndLastName(firstName: String, lastName: String): List<User>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("delete from user where name like :badName OR lastName like :badName")
    fun deleteUsersByName(badName: String): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertOrReplaceUsers(vararg users: User)

    @Delete
    fun deleteUsers(user1: User, user2: User)

    @Query("SELECT * FROM User WHERE :age == :age") // TODO: Fix this!
    fun findUsersYoungerThan(age: Int): List<User>

    @Query("SELECT * FROM User WHERE age < :age")
    fun findUsersYoungerThanSolution(age: Int): List<User>

    @Query("DELETE FROM User")
    fun deleteAll()
}