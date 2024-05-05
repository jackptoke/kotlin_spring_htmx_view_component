package au.com.amesystems.kotlinspringhtmxviewcomponentstarter.core.data

import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "harness")
@NoArg
class Harness(
    name: String,
    description: String,
    createdDate: LocalDateTime = LocalDateTime.now(),
    modifiedDate: LocalDateTime = LocalDateTime.now(),
    createdBy: String,
    modifiedBy: String,
    val revision: String = "",
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    val parent: Harness? = null,
    @OneToMany(mappedBy = "parent")
    val children: Set<Harness> = emptySet(),
    ) : BaseComponent(
    null, name, description, createdDate, modifiedDate, createdBy, modifiedBy
        ) {
}