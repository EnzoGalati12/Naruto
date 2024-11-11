import androidx.room.Room
import com.example.dragonballgs.data.local.AppDatabase
import com.example.dragonballgs.data.remote.api.DragonBallService
import com.example.dragonballgs.data.repository.DragonBallRepositoryImpl
import com.example.dragonballgs.domain.repository.DragonBallRepository
import com.example.dragonballgs.domain.usecase.DeleteAllHistoryUseCase
import com.example.dragonballgs.domain.usecase.DeleteItemHistoryUseCase
import com.example.dragonballgs.domain.usecase.GetDragonBallUseCase
import com.example.dragonballgs.domain.usecase.GetHistoryDragonBallUseCase
import com.example.dragonballgs.presentation.detail.DetalheViewModel
import com.example.dragonballgs.presentation.history.DragonBallViewModel
import com.example.dragonballgs.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://narutodb.xyz/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DragonBallService::class.java)
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(get(), AppDatabase::class.java, "dragon_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<AppDatabase>().dragonBallDao() }
}


val repositoryModule = module {
    single<DragonBallRepository> { DragonBallRepositoryImpl(get(), get()) }
}

val useCaseModule = module {
    factory { GetDragonBallUseCase(get()) }
    factory { GetHistoryDragonBallUseCase(get()) }
    factory { DeleteItemHistoryUseCase(get()) }
    factory { DeleteAllHistoryUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { DetalheViewModel(get()) }
   viewModel { DragonBallViewModel(get(), get(), get()) }
}